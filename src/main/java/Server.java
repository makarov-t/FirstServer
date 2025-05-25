import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection accepted");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String name = in.readLine();
            System.out.println("Received: " + name + " from port " + clientSocket.getPort());

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
        }
    }
}