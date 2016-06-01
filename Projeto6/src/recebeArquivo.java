/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.*; 


public class recebeArquivo {
   /*public static void main(String[] args) {

        //Criando Classe cliente para receber arquivo
        recebeArquivo cliente = new recebeArquivo();
        //Solicitando arquivo
        cliente.getFileFromFileServe();
    }*/

    public void getFileFromFileServe(String dir) {
        Socket sock = null;
        FileOutputStream file = null;
        InputStream is = null;
		DataOutputStream out = null;

        try {
            System.out.println("Informe nome do arquivo para download:");
			Scanner scn = new Scanner(System.in);
			String arquivo = scn.nextLine();
			String diretorio = dir;
			String baixar = diretorio+arquivo;

            // Cria arquivo local no cliente
            file = new FileOutputStream(new File(baixar));
            System.out.println("");
			System.out.println("O arquivo será criado em "+diretorio);
			System.out.println("");
			
			sock = new Socket("127.0.0.1", 1234);
			out = new DataOutputStream(sock.getOutputStream());
			out.writeUTF(arquivo);
			
			// Criando conexão com o servidor
            System.out.println("Solicitando arquivo "+arquivo+" ao Servidor");
			System.out.println("");
            //socket = new Socket("localhost", 1234);
            is = sock.getInputStream();			

            // Prepara variaveis para transferencia
            byte[] cbuffer = new byte[1024];
            int bytesRead;

            // Copia conteudo do canal
            System.out.println("Download em andamento...");
			System.out.println("");
            while ((bytesRead = is.read(cbuffer)) != -1) {
                file.write(cbuffer, 0, bytesRead);
                file.flush();
            }

            System.out.println("Download concluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if (file != null) {
                try {
                    file.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}