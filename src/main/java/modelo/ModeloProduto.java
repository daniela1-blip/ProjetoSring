package modelo; // Pacote de modelos (entidades) do projeto

import jakarta.persistence.Entity;               // Marca a classe como entidade de banco de dados
import jakarta.persistence.GeneratedValue;       // Para gerar ID automaticamente
import jakarta.persistence.GenerationType;       // Tipo de geração de ID
import jakarta.persistence.Id;                    // Marca o atributo como chave primária

@Entity  // Indica que esta classe será uma tabela no banco de dados
public class ModeloProduto {

    @Id  // Define o campo 'id' como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Geração automática do ID pelo banco
    private Long id;

    private String nome;  // Nome do produto
    private Double preco; // Preço do produto

    // Construtor vazio necessário para o JPA
    public ModeloProduto() {}

    // Construtor com atributos para facilitar criação de objetos
    public ModeloProduto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e setters são métodos para acessar e alterar os atributos

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
