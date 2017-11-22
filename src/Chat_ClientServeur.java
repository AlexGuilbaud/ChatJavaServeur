import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;


public class Chat_ClientServeur implements Runnable {

    private Socket socket = null;
    public BufferedReader in = null;
    public PrintWriter out = null;
    private Thread t3, t4;


    public Chat_ClientServeur(Socket s){

        socket = s;
    }
    public void run() {

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            Thread t3 = new Thread(new Reception(in));
            t3.start();
           // Thread t4 = new Thread(new Emission(out));
           // t4.start();

        } catch (SocketException e){
            System.out.println(socket.getInetAddress()+"s'est déconnecté");
            Accepter_connexion.sockets.remove(this);
        } catch (IOException e) {

        }
    }
}