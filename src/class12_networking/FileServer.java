package class12_networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServer {
	
    public static void main(String[] args) {
    	
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("File Server started...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected...");

                Path filePath = Paths.get("example.txt");
                try (BufferedReader reader = Files.newBufferedReader(filePath); OutputStream out = clientSocket.getOutputStream()) {
                    String line;
                    while ((line = reader.readLine()) != null) {
//                        System.out.println(line); // Print each line
                        out.write( line.getBytes() );  // Send data to client
                    }
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the IOException
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

