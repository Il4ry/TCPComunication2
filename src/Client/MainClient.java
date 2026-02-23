package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client");

        /*Scanner sc = new Scanner(System.in);

        Client c = new Client("Ilaria");
        System.out.println("Inserisci il nome del server per la connessione: ");
        String nomeServer = sc.nextLine();
        System.out.println("Inserisci il numero della porta per la connessione: ");
        int portaServer = sc.nextInt();
        c.connetti(nomeServer, portaServer);

        c.scrivi();
        c.leggi();
*/

        try {
            Socket socket = new Socket("localhost", 3000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw= new PrintWriter(outputStream);
            System.out.println("Scrivi il messaggio da voler mandare al server: ");
            Scanner sc = new Scanner(System.in);
            String primoMessaggio = sc.nextLine();
            pw.println(primoMessaggio);
            pw.flush();
            System.out.println("Messaggio inviato");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messaggioServer = br.readLine();
            /*System.out.println("Scrivi il messaggio da voler mandare al server: ");
            String messaggioClient = sc.nextLine();
            pw.println(messaggioClient);
            pw.flush();
            System.out.println("Messaggio inviato");*/
            if(messaggioServer.isEmpty()){
                System.out.println("messaggio vuoto");
                socket.close();
                System.out.println("Socket chiusa");
            }else{
                System.out.println("Server: "+ messaggioServer);
                System.out.println("Scrivi il messaggio da voler mandare al server: ");
                String messaggioClient = sc.nextLine();
                pw.println(messaggioClient);
                pw.flush();
                System.out.println("Messaggio inviato");
            }

        } catch (IOException e) {
            System.out.println("Errore");

        }
    }
}