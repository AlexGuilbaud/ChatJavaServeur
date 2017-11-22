import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class writelog {

   public writelog(String txt){

       BufferedWriter bw = null;
       FileWriter fw = null;


       try {

           fw = new FileWriter("log.txt",true);
           bw = new BufferedWriter(fw);
           bw.write(LocalDateTime.now()+" "+txt);
           bw.write("\r\n");

       } catch (IOException e) {

           e.printStackTrace();

       } finally {

           try {

               if (bw != null)
                   bw.close();

               if (fw != null)
                   fw.close();

           } catch (IOException ex) {

               ex.printStackTrace();

           }

       }
    }
}
