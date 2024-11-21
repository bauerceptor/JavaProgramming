package class12_networking;

import java.net.*;
import java.io.*;

public class URLExample {
	
    public static void main(String[] args) {
    	
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users/1");// "https://www.example.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

