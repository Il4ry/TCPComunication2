package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione");

        Server s = new Server(3000);
        Socket client = s.attendi();
        String messaggioClient= s.leggi();
        while(true){
            if(messaggioClient.isEmpty()){
                System.out.println("Messaggio vuoto");
                s.chiudi();
                s.termina();
            }else{
                s.scrivi();
                
            }
        }

        /*try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("\nSERVER: in attesa di richieste dal cliente");
            Socket clientSocket = server.accept();
            System.out.println("Connessione riuscita");
            System.out.println("Client connesso: " + clientSocket);
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messaggioClient;
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            Scanner sc = new Scanner(System.in);

            while ((messaggioClient = br.readLine()) != null) {
                if (messaggioClient.isEmpty()) {
                    System.out.println("Messaggio vuoto");
                    clientSocket.close();
                    System.out.println("Socket chiusa");
                    sc.close();
                    br.close();
                    break;
                } else {
                    System.out.println("Client: " + messaggioClient);
                    System.out.println("Scrivi il messaggio da voler mandare al client: ");
                    String messaggioServer = sc.nextLine();
                    pw.println(messaggioServer);
                    pw.flush();
                    System.out.println("Messaggio inviato");
                }
            }
        } catch (IOException e) {
            System.out.println("SERVER: Errore di connessone");
        }*/
    }
}