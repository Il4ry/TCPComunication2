package Client;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client");

        Scanner sc = new Scanner(System.in);

        Client c = new Client("Ilaria");
        System.out.println("Inserisci il nome del server per la connessione: ");
        String nomeServer = sc.nextLine();
        System.out.println("Inserisci il numero della porta per la connessione: ");
        int portaServer = sc.nextInt();
        c.connetti(nomeServer, portaServer);

        c.scrivi();
    }
}