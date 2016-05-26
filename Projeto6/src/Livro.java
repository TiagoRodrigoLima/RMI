
public class Livro {

    int isbn, quantidade;
    String nomeLivro;

    public Livro(int isbn, int quantidade, String nomeLivro) {
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.nomeLivro = nomeLivro;
    }
    
    public Livro() {
        
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getQuantidade() {
        return quantidade;
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

}
