package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione");


        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("SERVER: in attesa di richieste dal cliente");
            Socket clientSocket = server.accept();
            System.out.println("Server connesso");
        } catch (IOException e) {
            System.out.println("SERVER: ");
        }


    }
}