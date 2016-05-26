
import java.rmi.*;

public class BibliServer {

    public static void main(String[] arg) {
        try {
            Naming.rebind("biblioteca", new BibliImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
