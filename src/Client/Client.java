package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    String host;
    Socket socket;

    public Client(String host) {
        this.host = host;

    }

    public void connetti(String serverName, int serverPort) {
        try {
            socket = new Socket(serverName, serverPort);
            System.out.println("Socket creata");
        } catch (IOException e) {
            System.out.println("Porta non disponibile");
        }
    }

    public void scrivi(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw= new PrintWriter(outputStream);
            System.out.println("Scrivi il messasggio da voler mandare al server: ");
            Scanner sc = new Scanner(System.in);
            String messaggio = sc.nextLine();
            pw.println(messaggio);
            pw.flush();
            System.out.println(host + ": ha inviato un messaggio al server");
        } catch (IOException e) {
            System.out.println("Errore messaggio non inviato");
        }
    }

    public void leggi(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messaggio = br.readLine();
            System.out.println("Messaggio del client: " + messaggio);
        } catch (IOException e) {
            System.out.println("Errore nella lettura del messaggio");
        }
    }

    public void chiudi() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                System.out.println("Connessione chiusa con il server");
            }
        } catch (IOException e) {
            System.out.println("Errore durante la chiusura della connessione");
        }
    }

}
