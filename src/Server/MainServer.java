package Server;

import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione");

        System.out.println("Inserire numero della porta: ");
        Scanner sc = new Scanner(System.in);
        int porta = sc.nextInt();
        Server s = new Server(porta);

        Socket clientSocket = s.attendi();
        s.leggi();

        /*try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("\nSERVER: in attesa di richieste dal cliente");
            Socket clientSocket = server.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messaggio = br.readLine();
            System.out.println("Connessione riuscita");
            System.out.println("Client connesso: " + clientSocket);
            System.out.println("Messaggio del client: " + messaggio);
        } catch (IOException e) {
            System.out.println("SERVER: Errore di connessone");
        }*/


    }
}