import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class User1 extends Frame implements ActionListener,Runnable
{
 //Declarations
 Button b;
 TextField tf;
 TextArea ta;
 static Socket clientsocket=null;
  static PrintStream outToserver = null; 
  static BufferedReader in_from_server=null;
  static BufferedReader inputline=null;
  static boolean closed = false;
  static Thread client_thread;
  static User1 client;
 
 public void hh()
 {
  Frame f=new Frame("Client Side Chatting");//Frame for Client
  f.setLayout(new FlowLayout());//set layout
  f.setBackground(Color.orange);//set background color of the Frame
  b=new Button("Send");//Send Button
  b.addActionListener(this);//Add action listener to send button.
  f.addWindowListener(new W1());//add Window Listener to the Frame
  tf=new TextField(15);
  ta=new TextArea(60,60);
  ta.setBackground(Color.cyan);
  f.add(tf);//Add TextField to the frame
  f.add(b);//Add send Button to the frame
  f.add(ta);//Add TextArea to the frame



  setFont(new Font("Arial",Font.BOLD,20));
  f.setSize(200,200);//set the size
  f.setVisible(true);
  f.setLocation(100,300);//set the location
  f.validate();
 }
 //method required to close the Frame on clicking "X" icon.

 //This method will called after clicking on Send button.
 public void actionPerformed(ActionEvent ae)
 {
         if(clientsocket!=null&& outToserver !=null)
  {
    System.out.println("fffdsaaa11");

    try{
      client_thread=new Thread(client);
    client_thread.start();
   
   if(!closed)
   {
     String s=tf.getText();
     outToserver.println(s); 
   }
   else
   {
   outToserver.close();
    in_from_server.close();
    clientsocket.close();
    System.exit(0);
    }

  }
  catch(Exception e)
{
    
}
  
}

 }
 //Thread running as a process in background
 public void run()
 {
  String client_sentence;
  try{

    
    while((client_sentence = in_from_server.readLine()) !=null)
    {
      ta.append(client_sentence+"\n");
      if(client_sentence.indexOf("Bye")!=-1)
      break;
    }
    closed=true;
 }
 catch (IOException e) {
      System.err.println("IOException:  " + e);
    }

}
 //Main method
 public static void main(String args[])
 {
  
  int port_number=6990;
    String host="localhost";

 try{



    clientsocket=new Socket(host,port_number);
    outToserver = new PrintStream(clientsocket.getOutputStream());
    in_from_server = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
   
  }
catch(Exception e)  {}
client = new User1();
client.hh();


  
  
 }
}
