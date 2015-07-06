package cliente;
import java.io.*;
import java.io.FileReader;
import java.net.*;
import java.lang.Thread;
import java.io.File;
import java.io.FileWriter;

public class TCPServerThread implements Runnable {
	
	private Socket M_socket;
	private String M_msg;



	public TCPServerThread(Socket socket)
	{
		M_socket = socket;
	}

	void gravarArquivo(String msg)
	/* A funcao principal da thread . Ao final da sua execucao uma mensagem
	 * com o nome do arquivo criado devera ser enviada para o cliente TCP
	 * que estiver conectado na thread .
	 */
	
	{
             

            
    }
         
    	
	

		public void run()
	{

		try
		{
			DataOutputStream paraCliente = new DataOutputStream(M_socket.getOutputStream());
			paraCliente.writeBytes("<html><body><h1>Olá Kleber!!!!</h1></body></html>");
			FileReader ler = new FileReader("./index.html");
			BufferedReader buffer = new BufferedReader(ler);
			String linha = buffer.readLine();
			
			File salvar = new File("C:/Users/Kleber/Desktop/Alander-Exercicios Java/TR2/teste.txt");
			FileWriter gravar = new FileWriter(salvar);
			
			while (linha != null)
			{
				paraCliente.writeBytes(linha);
				linha = buffer.readLine();
			}

			M_socket.close();
		}
		catch (Exception ex)
		{
			System.out.println("Erro: " + ex.getMessage());	
		}
	}
}
