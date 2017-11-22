import java.io.*;
import java.net.SocketException;
import java.io.IOException;


public class Reception implements Runnable {


    private BufferedReader in;
    private String message = null;

    public Reception(BufferedReader in){
        this.in = in;
    }

    public void run() {

        while(true){
            try {
                message = in.readLine();
                System.out.println(message);
                if(message.startsWith("Sous le pseudo suivant : ")){
                    new writelog(message);
                }else {

                    for (Chat_ClientServeur sockets : Accepter_connexion.sockets) {
                        if (this.in != sockets.in) {
                            sockets.out.println(message);
                            sockets.out.flush();
                        }
                    }
                }

            } catch (SocketException e){
                break;
            }
            catch (IOException e) {
            }
        }
        String[] parts = message.split(":");
        String part1 = parts[0]; // pseudo
        String part2 = parts[1]; // message

        String deco = "L'utilisateur : "+part1+" s'est déconnecté";
        new writelog(deco);
        System.out.println("L'utilisateur : "+part1+" s'est déconnecté ");
    }
}