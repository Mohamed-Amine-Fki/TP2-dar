package Ex1;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[]args) {
		try {
			ServerSocket Server = new ServerSocket(1234);
			System.out.println("le serveur attend la connexion d'un client ");
			Socket socket = Server.accept();
			System.out.println("un client est connecté");
			InputStream is = socket.getInputStream();
			int op1,op2,result1;
			String operation;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			op1=Integer.parseInt(br.readLine());
			op2=Integer.parseInt(br.readLine());
			operation=br.readLine();
			switch (operation) {
            case "+":
                result1 =op1+op2;
                break;
            case "-":
                result1 =op1-op2;
                break;
            case "*":
                result1 = op1*op2;
                break;
            case "/":
                if (op2 == 0) {
                    throw new ArithmeticException("Division par zéro");
                }
                result1 = op1/op2;
                break; default: throw new IllegalArgumentException("Opérateur non valide"); }
			System.out.println(result1);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			pw.print(result1);
			socket.close();
			Server.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();	}}
}






