
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class BibliImpl extends UnicastRemoteObject implements BibliInterface {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int[] v;

    List<Livro> livros = new ArrayList<>();
    List<Aluno> alunos = new ArrayList<>();

    public BibliImpl() throws RemoteException {

    }

    @Override
    public void cadastrarAluno(String nome, int num) throws RemoteException {
        Aluno aluno = new Aluno();

        System.out.println("Aluno cadastrado:");
        System.out.println("Nome : " + nome);
        System.out.println("Matricula : " + num + "\n");

        aluno.setNome(nome);
        aluno.setNum(num);

        alunos.add(aluno);

    }

    @Override
    public String consultarAlunos(int num) throws RemoteException {

        for (Aluno listaaluno : alunos) {
            if (listaaluno.getNum() == num) {
                System.out.println("Aluno consultado : " + listaaluno.getNome() + "\n");
                return listaaluno.getNome();
            }
        }

        return null;
    }

    @Override
    public void cadastrarLivro(int isbn, String nomeLivro, int quantidade) throws RemoteException // String nome , int num
    {
        Livro livro = new Livro(isbn, quantidade, nomeLivro);

        System.out.println("Livro cadastrado:");
        System.out.println("Nome: " + nomeLivro);
        System.out.println("Isbn: " + isbn);
        System.out.println("Quantidade: " + quantidade + "\n");

        livros.add(livro);

    }

    @Override
    public String consultarLivro(int isbn) throws RemoteException {
        String resultadoConsulta = "";
        for (Livro livro : livros) {
            if (livro.getIsbn() == isbn) {
                System.out.println("Livro consultado : " + livro.getNomeLivro());
                resultadoConsulta = "Nome: " + livro.getNomeLivro() + "\nIsbn: "
                        + livro.getIsbn() + "\nQuantidade: " + livro.getQuantidade() + "\n";
                return resultadoConsulta;
            }
        }

        return null;
    }

    @Override
    public void emprestarLivro(int isbn, String nomeDoLivro) throws RemoteException {
        for (Livro listalivros : livros) {
            if (listalivros.getIsbn() == isbn) {
                listalivros.setQuantidade(listalivros.quantidade - 1);
                System.out.println("Livro emprestado:\nNome:" + listalivros.getNomeLivro());
                System.out.println("Isbn: " + listalivros.getIsbn());
                System.out.println("Quantidade: " + listalivros.getQuantidade() + "\n");
            }
        }

    }

    @Override
    public void devolverLivro(int isbn) throws java.rmi.RemoteException {

        for (Livro listalivros : livros) {
            if (listalivros.getIsbn() == isbn) {
                System.out.println("Livro devolvido : " + listalivros.getNomeLivro() + "\n");
                listalivros.setQuantidade(listalivros.quantidade + 1);
            }
        }
    }

    @Override
    public String listarAlunos() throws RemoteException {
        String listaDeAlunos = "";
        for (Aluno aluno : alunos) {
            listaDeAlunos += "Nome: " + aluno.getNome()+ "\n"
                    + "Número: " + aluno.getNum()+ "\n";
            
        }
        
        return listaDeAlunos;
    }

    @Override
    public String listarLivros() throws RemoteException {
        String listaDeLivros = "";
        for (Livro livro : livros) {
            listaDeLivros += "Título: " + livro.getNomeLivro() + "\n"
                    + "ISBN: " + livro.getIsbn() + "\n"
                    + "Quantidade: " + livro.getQuantidade() + "\n";
            
        }
        
        return listaDeLivros;
    }
    
}
