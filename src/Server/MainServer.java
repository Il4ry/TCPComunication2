package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: Inizio esecuzione");
/*
        System.out.println("Inserire numero della porta: ");
        Scanner sc = new Scanner(System.in);
        int porta = sc.nextInt();
        Server s = new Server(porta);

        Socket clientSocket = s.attendi();
        s.leggi();
        s.scrivi();
*/
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("\nSERVER: in attesa di richieste dal cliente");
            Socket clientSocket = server.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messaggioClient = br.readLine();
            System.out.println("Connessione riuscita");
            System.out.println("Client connesso: " + clientSocket);
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter pw= new PrintWriter(outputStream);
            Scanner sc = new Scanner(System.in);
            if(messaggioClient.isEmpty()){
                clientSocket.close();
                sc.close();
                br.close();
            }else{
                System.out.println("Client: " + messaggioClient);
                System.out.println("Scrivi il messaggio da voler mandare al client: ");
                String messaggioServer = sc.nextLine();
                pw.println(messaggioServer);
                pw.flush();
                System.out.println("Messaggio inviato");
            }
        } catch (IOException e) {
            System.out.println("SERVER: Errore di connessone");
        }


    }
}