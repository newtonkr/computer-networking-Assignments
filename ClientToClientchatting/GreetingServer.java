// File Name GreetingServer.java
import java.net.*;
import java.io.*;
import java.util.*;

public class GreetingServer extends Thread {
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException {
      serverSocket = new ServerSocket(port);
   }

   public void run() {
      while(true) {
         try {
            System.out.println("Waiting for client on port " + 
               serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            while(true)
            {
            DataInputStream in = new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            Scanner kbd = new Scanner(System.in);
            String s = kbd.nextLine();
            out.writeUTF(s);
            if(s.length()==0)
            {
               break;
            }

         }
            server.close();
            
         }
         catch(IOException e) {
            e.printStackTrace();
            break;
         }

      }
   }
   
   public static void main(String [] args) {
      int port = Integer.parseInt(args[0]);
      try {
         Thread t = new GreetingServer(port);
         t.start();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}