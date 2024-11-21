package class12_networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileClient {
	
    public static void main(String[] args) {
    	
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connected to server...");

            Path filePath = Paths.get("received_example.txt");

            // Use a ByteArrayOutputStream to collect bytes from the server
            try (InputStream in = socket.getInputStream()) {

                Files.write(filePath, in.readAllBytes() );  // Write all bytes at once
                
                System.out.println("File received from server.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

