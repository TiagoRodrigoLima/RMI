
public interface BibliInterface extends java.rmi.Remote {

    public void cadastrarAluno(String nome, int num)
            throws java.rmi.RemoteException;

    public String consultarAlunos(int num)
            throws java.rmi.RemoteException;
    
    public String listarAlunos() 
            throws java.rmi.RemoteException;

    public void cadastrarLivro(int isbn, String nomeLivro, int quantidade)
            throws java.rmi.RemoteException;
    
    public String listarLivros() 
            throws java.rmi.RemoteException;
    
    public String consultarLivro(int isbn)
            throws java.rmi.RemoteException;

    public void emprestarLivro(int isbn, String nomedoLivro)
            throws java.rmi.RemoteException;

    public void devolverLivro(int isbn)
            throws java.rmi.RemoteException;
      
}
