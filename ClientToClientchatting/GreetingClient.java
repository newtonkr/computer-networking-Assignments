import java.net.*;
import java.io.*;
import java.util.*;

public class GreetingClient {

   public static void main(String [] args) {
      Scanner kbd = new Scanner(System.in);
      
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         while(true)
      {
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         String s = kbd.nextLine();
         out.writeUTF(s);
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         
         System.out.println(in.readUTF());
           if(s.length()==0)
            {
               break;
            }
      }
         client.close();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}