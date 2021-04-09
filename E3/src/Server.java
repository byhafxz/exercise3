import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		try {
			
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo);
			
			String texttype = "Hello Java String Method";
			System.out.println("Waiting or request");
			
			int length = texttype.length();
			
			while (true) {
				
				Socket clientSocket = serverSocket.accept();
				
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				outputStream.writeUTF("" + length);
				
				clientSocket.close();
				
			}
			
		} catch (IOException ioe) {
			
			if (serverSocket != null)
				serverSocket.close();
			
			ioe.printStackTrace();
		}
	}
}
