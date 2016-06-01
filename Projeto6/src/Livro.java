
import java.io.File;


public class Livro {

    int isbn, quantidade;
    String nomeLivro;
    File livro;

    public String getNomeLivro() {
        return nomeLivro;
    }
    
    public int getIsbn() {
        return isbn;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public File getLivro() {
        return livro;
    }
    
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setLivro(File livro) {
        this.livro = livro;
    }
    
}
