import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port + " (netology.homework)");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("\nNew connection accepted from " + clientSocket.getInetAddress());

                    out.println("Write your name:");
                    String name = in.readLine();
                    System.out.println("Client name: " + name);

                    out.println("Are you child? (yes/no)");
                    String isChild = in.readLine().toLowerCase();
                    System.out.println("Is child: " + isChild);

                    if (isChild.equals("yes")) {
                        out.println("Welcome to the kids area, " + name + "! Let's play!");
                    } else {
                        out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                    }


                } catch (IOException e) {
                    System.err.println("Error in client handling: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
        }
    }
}