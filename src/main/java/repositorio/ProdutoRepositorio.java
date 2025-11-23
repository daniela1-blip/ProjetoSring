// Pacote onde a interface está localizada
// Precisa refletir a pasta real dentro de src/main/java
package repositorio;

import modelo.ModeloProduto;  // Importa a entidade ModeloProduto para que o repositório saiba com qual tabela/banco ele vai trabalhar
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface do Spring Data JPA que fornece métodos prontos de CRUD
import org.springframework.stereotype.Repository;             // Marca esta interface como um repositório do Spring

// @Repository informa ao Spring que esta interface é um componente de acesso a dados (DAO)
// Ele também permite que exceções de banco de dados sejam traduzidas para exceções do Spring
@Repository
public interface ProdutoRepositorio 
        extends JpaRepository<ModeloProduto, Long> {  
    // Aqui estamos dizendo: "Esta interface vai operar com a entidade ModeloProduto, 
    // cujo tipo de ID é Long"
    
    // JpaRepository já fornece os métodos CRUD prontos, como:
    // save()      → para salvar ou atualizar
    // findAll()   → para listar todos
    // findById()  → para buscar por ID
    // deleteById()→ para deletar por ID

    // Você pode adicionar métodos personalizados, se precisar, usando a convenção de nomes do Spring Data JPA
    // Por exemplo: List<ModeloProduto> findByNome(String nome);
}
