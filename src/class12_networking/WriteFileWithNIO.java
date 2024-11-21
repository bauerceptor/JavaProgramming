package class12_networking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class WriteFileWithNIO {
    public static void main(String[] args) {
        // Define the file path
        Path filePath = Paths.get("example.txt");

        // Define the content to write
        String content = "Hello, this is a sample text written using Java NIO!";

        try {
            // Write content to file, overwriting if it already exists
            Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
    }
}