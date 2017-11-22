import java.io.IOException;
import java.net.ServerSocket;


public class ServerSocketChat {

    public static Thread t;

    public ServerSocketChat() {

        final ServerSocket serveurSocket ;

        try {
            serveurSocket = new ServerSocket(5000);
            System.out.println("\033[32;1;2m Le serveur est à l'écoute du port "+serveurSocket.getLocalPort()+"\033[0m");

            t = new Thread(new Accepter_connexion(serveurSocket));

            t.start();

        }catch (IOException e) {
            System.err.println("\033[31;1m Le port est déjà utilisé ! \033[32;1;2m");
        }
    }
}