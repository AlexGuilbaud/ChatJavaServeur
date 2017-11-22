import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class Accepter_connexion implements Runnable{

    public static ArrayList<Chat_ClientServeur> sockets = new ArrayList<>();
    private ServerSocket socketserver = null;
    private Socket socket = null;

    public Thread t2;
    public Accepter_connexion(ServerSocket ss){

        socketserver = ss;

    }

    public void run() {
        try {


            while(true){

                socket = socketserver.accept();
                System.out.println("\033[32;1;2m Un utilisateur vient de se connecter (" + socket.getInetAddress() + ")\033[0m");

                String newconnection = "Un utilisateur vient de se connecter (" + socket.getInetAddress() + ")";
                new writelog(newconnection);

                Chat_ClientServeur clients = new Chat_ClientServeur(socket);
                sockets.add(clients);
                t2 = new Thread(clients);
                t2.start();

            }

        } catch (IOException e) {

            System.err.println("\033[31;1m Erreur serveur \033[0m");
        }
    }

}