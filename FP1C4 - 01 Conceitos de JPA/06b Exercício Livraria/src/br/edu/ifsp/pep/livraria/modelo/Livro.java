package br.edu.ifsp.pep.livraria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

@Entity
@Table(name = "livro")
@NamedQueries({
    @NamedQuery(name = "buscarPorCodigo",
            query = "SELECT l FROM Livro l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "buscarPorISBN",
            query = "SELECT l FROM Livro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "buscarPorAutor",
            query = "SELECT l FROM Livro l WHERE l.autor = :autor"),
    @NamedQuery(name = "buscarPorTitulo",
            query = "SELECT l FROM Livro l WHERE l.titulo LIKE :titulo")
}
)
public class Livro implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    @Id
    private Integer codigo;

    @Column(name = "isbn", nullable = false, length = 13)
    private String isbn;

    @Column(name = "autor", nullable = false, length = 60)
    private String autor;

    @Column(name = "titulo", nullable = false, length = 60)
    private String titulo;

    @Column(name = "pagina")
    private Integer paginas;

    @Column(name = "preco", nullable = false, precision = 8, scale = 2)
    private BigDecimal preco;

    // Código gerado....
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Livro{" + "codigo=" + codigo + ", isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", paginas=" + paginas + ", preco=" + preco + '}';
    }

    public Livro(String isbn, String autor, String titulo, Integer paginas, BigDecimal preco) {
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.paginas = paginas;
        this.preco = preco;
    }

    public Livro() {
    }
}
