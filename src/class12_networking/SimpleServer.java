package class12_networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {
		
		try (ServerSocket serverSocket = new ServerSocket(1234)) {

			System.out.println("Server is listening on port 1234");

			// Accept client connection
			Socket socket = serverSocket.accept();
			System.out.println("Client connected");

			// Set up input and output streams
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

			// Read the message from the client
			String message = input.readLine();
			System.out.println("Received from client: " + message);

			// Send a fixed response back to the client
			output.println("Message received");

			// Close the connection
//			socket.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}