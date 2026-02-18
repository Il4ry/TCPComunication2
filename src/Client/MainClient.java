package Client;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client");

        try {
            Socket socket = new Socket("localhost", 3000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw= new PrintWriter(outputStream);
            pw.print("Ciao Server");
            pw.flush();
            System.out.println("ClIENT: il cliente ha inviato un messaggio");
        } catch (IOException e) {
            System.out.println("Porta non disponibile");
        }




    }
}