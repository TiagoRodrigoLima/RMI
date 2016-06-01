/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.io.DataInputStream;


	public class enviaArquivo {
	   // public static void main(String[] args) {

	        // Criando servidor
	        //enviaArquivo server = new enviaArquivo();

	        // Aguardar conexao de cliente para transferia
	        //server.waitForClient();

	  //  }

	    public void waitForClient() {

	        // Checa se a transferencia foi completada com sucesso
	        OutputStream out = null;
	        ServerSocket servsock = null;
	        FileInputStream fileIn = null;

	        try {
	            // Abrindo porta para conexao de clients
	            servsock = new ServerSocket(1234);
	            System.out.println("Aguardando solicitações na porta 1234");
				System.out.println("");

	            // Cliente conectado
	            Socket sock = servsock.accept();
	            System.out.println("Recebendo solicitação");
				System.out.println("");
				
				DataInputStream in = new DataInputStream(sock.getInputStream());
				
				String arquivo = in.readUTF();
				String caminho = "C:\\Shared\\"+arquivo;

	            // Criando tamanho de leitura
	            byte[] cbuffer = new byte[1024];
	            int bytesRead;
				
				// Criando arquivo que sera transferido pelo servidor
				// Coloque o caminho de um arquivo em sua maquina
	            File file = new File(caminho);
	            fileIn = new FileInputStream(file);
	            
	            // Criando canal de transferencia
	            out = sock.getOutputStream();

	            // Lendo arquivo criado e enviando para o canal de transferencia
	            System.out.println("Enviando Arquivo: "+arquivo);
				System.out.println("");
	            while ((bytesRead = fileIn.read(cbuffer)) != -1) {
	                out.write(cbuffer, 0, bytesRead);
	                out.flush();
	            }

	            System.out.println("Upload concluído!");
				System.out.println("");
	        } catch (Exception e) {
	            // Mostra erro no console
	            e.printStackTrace();
	        } finally {
	            if (out != null) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }

	            if (servsock != null) {
	                try {
	                    servsock.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }

	            if (fileIn != null) {
	                try {
	                    fileIn.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}
