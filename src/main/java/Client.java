import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server at " + host + ":" + port);

            System.out.println("Server: " + in.readLine());
            System.out.print("Your name: ");
            out.println(scanner.nextLine());

            System.out.println("Server: " + in.readLine());
            System.out.print("Your answer (yes/no): ");
            out.println(scanner.nextLine());

            System.out.println("Server: " + in.readLine());


        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            System.err.println("Did you add netology.homework to your hosts file?");
        } catch (IOException e) {
            System.err.println("Error in client: " + e.getMessage());
        }
    }
}