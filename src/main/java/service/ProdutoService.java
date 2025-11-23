// Pacote onde esta classe está localizada
// Precisa refletir a pasta real dentro de src/main/java
package service;

import modelo.ModeloProduto;          // Importa a classe ModeloProduto (entidade do banco)
import repositorio.ProdutoRepositorio; // Importa o repositório para acessar os dados
import org.springframework.stereotype.Service;          // Marca a classe como um Service do Spring
import java.util.List;                                 // Importa a List para retornar múltiplos produtos

// Anotação que diz ao Spring que esta classe é um Service (componente de lógica de negócio)
@Service
public class ProdutoService {

    // Injeção de dependência: vamos usar o ProdutoRepositorio para acessar o banco
    // 'final' garante que só será inicializado pelo construtor
    private final ProdutoRepositorio produtoRepositorio;

    // Construtor com injeção de dependência
    // O Spring vai automaticamente fornecer a instância de ProdutoRepositorio
    public ProdutoService(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    // Salva um produto no banco de dados
    // Recebe um objeto ModeloProduto e retorna o mesmo objeto depois de salvo (com id gerado)
    public ModeloProduto salvarProduto(ModeloProduto produto) {
        return produtoRepositorio.save(produto);
    }

    // Retorna todos os produtos cadastrados no banco
    public List<ModeloProduto> listarProdutos() {
        return produtoRepositorio.findAll();
    }

    // Busca um produto pelo seu ID
    // Se não encontrar, retorna null
    public ModeloProduto buscarPorId(Long id) {
        return produtoRepositorio.findById(id).orElse(null);
    }

    // Deleta um produto pelo ID
    public void deletarProduto(Long id) {
        produtoRepositorio.deleteById(id);
    }
}
