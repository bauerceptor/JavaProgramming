package class12_networking;

import java.io.*;
import java.net.*;

public class SimpleClient {
	
    public static void main(String[] args) {
    	
        try (Socket socket = new Socket("localhost", 1234);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a single message to the server
            output.println("Hello, Server!");

            // Read and print the server's response
            String response = input.readLine();
            System.out.println("Server response: " + response);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
