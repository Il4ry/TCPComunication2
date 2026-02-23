package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    public Server (int porta) {
        this.porta = porta;
    }

    Scanner sc = new Scanner(System.in);

    public Socket attendi(){
        try {
            serverSocket = new ServerSocket(this.porta);
            System.out.println("\nSERVER: in attesa di richieste dal cliente");
            clientSocket = serverSocket.accept();
            System.out.println("Connessione riuscita");
        } catch (IOException e) {
            System.out.println("Errore nel ServerSocket");
        }
        return clientSocket;
    }

    public void leggi(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messaggio = br.readLine();
            System.out.println("Messaggio del client: " + messaggio);
        } catch (IOException e) {
            System.out.println("Errore nella lettura del messaggio");
        }
    }

    public void scrivi(){
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter pw= new PrintWriter(outputStream);
            System.out.println("Scrivi il messasggio da voler mandare al client: ");
            String messaggio = sc.nextLine();
            pw.println(messaggio);
            pw.flush();
        } catch (IOException e) {
            System.out.println("Errore: messaggio non inviato");
        }
    }
    public void chiudi() {
        try {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
                System.out.println("Connessione chiusa con il client");
            }
        } catch (IOException e) {
            System.out.println("Errore durante la chiusura della connessione");
        }
    }

    public void termina(){
        try {
            if (clientSocket != null && !clientSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Connessione chiusa");
                sc.close();
            }
        } catch (IOException e) {
            System.out.println("Errore durante la chiusura della connessione");
        }
    }


}
