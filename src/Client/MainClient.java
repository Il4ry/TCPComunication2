package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client");

        Client c = new Client("Ilaria");
        c.connetti("localhost", 3000);
        c.scrivi();
        String messaggioServer=c.leggi();
        while (messaggioServer!=null){
            if(messaggioServer.isEmpty()){
                System.out.println("Messaggio vuoto");
                c.chiudi();
                break;
            }else{
                c.scrivi();
                messaggioServer= c.leggi();
            }
        }
        

        /*try {
            Socket socket = new Socket("localhost", 3000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            System.out.println("Scrivi il messaggio da voler mandare al server: ");
            Scanner sc = new Scanner(System.in);
            String primoMessaggio = sc.nextLine();
            pw.println(primoMessaggio);
            pw.flush();
            System.out.println("Messaggio inviato");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messaggioServer;

            while ((messaggioServer = br.readLine()) != null) {
                if (messaggioServer.isEmpty()) {
                    System.out.println("Messaggio vuoto");
                    socket.close();
                    System.out.println("Socket chiusa");
                    break;
                } else {
                    System.out.println("Server: " + messaggioServer);
                    System.out.println("Scrivi il messaggio da voler mandare al server: ");
                    String messaggioClient = sc.nextLine();
                    pw.println(messaggioClient);
                    pw.flush();
                    System.out.println("Messaggio inviato");
                }
            }

        } catch (IOException e) {
            System.out.println("Errore");

        }*/
    }
}