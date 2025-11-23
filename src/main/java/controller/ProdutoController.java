package controller; // Pacote de controllers

//Pacote onde a classe está localizada


import modelo.ModeloProduto;  // Importa a entidade ModeloProduto para trabalhar com dados
import service.ProdutoService; // Importa o service que contém a lógica de negócio
import org.springframework.web.bind.annotation.*; // Importa anotações REST do Spring
import java.util.List; // Importa List para retornar múltiplos produtos

//@RestController combina @Controller + @ResponseBody
//Indica que esta classe vai expor endpoints REST que retornam JSON
@RestController  

//Define a rota base para todos os endpoints deste controller
//Exemplo: GET /produtos, POST /produtos, DELETE /produtos/{id}, etc.
@RequestMapping("/produtos") 
public class ProdutoController {

 // Serviço que contém a lógica de negócio
 private final ProdutoService produtoService;

 // Construtor com injeção de dependência
 // O Spring vai automaticamente passar uma instância de ProdutoService
 public ProdutoController(ProdutoService produtoService) {
     this.produtoService = produtoService;
 }

 // Endpoint GET /produtos
 // Retorna todos os produtos cadastrados
 @GetMapping
 public List<ModeloProduto> listar() {
     return produtoService.listarProdutos();
 }

 // Endpoint GET /produtos/{id}
 // @PathVariable pega o valor da URL e passa para o método
 @GetMapping("/{id}")
 public ModeloProduto buscar(@PathVariable Long id) {
     return produtoService.buscarPorId(id);
 }

 // Endpoint POST /produtos
 // @RequestBody indica que o objeto virá no corpo da requisição em JSON
 // Salva um novo produto usando o service
 @PostMapping
 public ModeloProduto criar(@RequestBody ModeloProduto produto) {
     return produtoService.salvarProduto(produto);
 }

 // Endpoint DELETE /produtos/{id}
 // Deleta um produto pelo ID
 @DeleteMapping("/{id}")
 public void deletar(@PathVariable Long id) {
     produtoService.deletarProduto(id);
 }
}
