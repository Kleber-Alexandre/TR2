import java.io.*;
import java.net.*;
import java.util.Scanner;
import cliente.TCPServerThread;

class ServidorApp

{
	private static int minha_porta = 9090;
	
	
	
	

	private static void aguardarConexao()throws IOException
	{
		int porta = minha_porta;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe a porta de conexao: ");
		porta = scanner.nextInt();
		if (porta == minha_porta)
		{
			try
			{
				ServerSocket servidor = new ServerSocket(porta);
				while (true)
				{
				System.out.println("Aguardando uma nova conexao...");
				Socket socket = servidor.accept();
				System.out.println("Nova conexao estabelecida. Criando nova thread de comunicacao...");
				Thread cliente = new Thread(new TCPServerThread(socket));
				cliente.start();
				System.out.println("Nova thread criada com sucesso.");
				}
			}
			catch (Exception e)
			{
				System.out.println("Erro: " + e.getMessage());
			}
		}
		else
		System.out.println("Erro: o valor da porta deve ser maior do que 0");
	
	
	
	
	
	}
	public static void main(String [] args) throws Exception 
	
	{
		ServidorApp.aguardarConexao();	
		
	}
}