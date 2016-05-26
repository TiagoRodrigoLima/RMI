
import java.rmi.Naming;
import java.util.Scanner;

public class BibliCliente {

    public static Scanner sc;
    
    public static void main(String[] arg) { 
        //System.setSecurityManager(new RMISecurityManager());
        BibliInterface v;
        Aluno aluno;
        Livro livro;
        String livroConsultado;
        String alunoConsultado;
        try {
            v = (BibliInterface) Naming.lookup("rmi://localhost:1099/biblioteca");
            sc = new Scanner(System.in);
            
            // Setar cadastro de aluno
            aluno = criarAluno();
            // Setar cadastro de livro
            livro = criarLivro();
            
            v.cadastrarAluno(aluno.getNome(), aluno.getNum());
            System.out.println("Aluno cadastrado com sucesso");
            
            // Cadastrar o livro
            v.cadastrarLivro(livro.getIsbn(), livro.getNomeLivro(), livro.getQuantidade());
            
            // Consultar livro
            alunoConsultado = v.consultarAlunos(aluno.getNum());
            System.out.println("Aluno Consultado : " + alunoConsultado);
            
            // Emprestar livro
            v.emprestarLivro(livro.getIsbn(), livro.getNomeLivro());
            
            // Consultar livro
            livroConsultado = v.consultarLivro(livro.getIsbn());
            // Mostrar livro consultado
            System.out.println(livroConsultado);
            
            // Emprestar livro
            v.emprestarLivro(livro.getIsbn(), livro.getNomeLivro());
            
            // Consultar livro
            livroConsultado = v.consultarLivro(livro.getIsbn());
            // Mostrar livro consultado
            System.out.println(livroConsultado);
            
            // Devolver livro
            v.devolverLivro(livro.getIsbn());
            
            // Consultar livro
            livroConsultado = v.consultarLivro(livro.getIsbn());
            // Mostrar livro consultado
            System.out.println(livroConsultado);
            
            // Listar alunos
            v.listarAlunos();
            
            // Listar livros
            v.listarLivros();
            
        } catch (Exception e) { /*...*/ }
    }
    
    public static Aluno criarAluno() {
            Aluno aluno =  new Aluno();
            sc = new Scanner(System.in);
            
            System.out.println("Digite o nome do aluno:");
            String nomeAluno = sc.nextLine();
            aluno.setNome(nomeAluno);
            
            System.out.println("Digite o numero do aluno:");
            int numAluno = sc.nextInt();
            aluno.setNum(numAluno);
            
            return aluno;
    }
    
    public static Livro criarLivro() {
            Livro livro =  new Livro();
            sc = new Scanner(System.in);
            
            System.out.println("Digite o nome do livro:");
            String nomeLivro = sc.nextLine();
            livro.setNomeLivro(nomeLivro);
            
            System.out.println("Digite o isbn do livro:");
            int isbnLivro = sc.nextInt();
            livro.setIsbn(isbnLivro);
            
            System.out.println("Digite a quantidade do livro:");
            int qtdLivro = sc.nextInt();
            livro.setQuantidade(qtdLivro);
            
            return livro;
    }
}
