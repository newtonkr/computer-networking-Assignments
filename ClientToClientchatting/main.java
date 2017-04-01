import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;

class main
{
public static void main(String args[])
 { 
  addition1 client = new addition1();
  client.func();
 }
}
public class addition1 extends Frame implements Runnable
{
 //Declarations
 JButton b;
 JTextField tf;
 JTextArea ta;
 Socket s;
 PrintWriter pw;
 BufferedReader br;
 Thread th;
 Socket connectionSocket;
 ServerSocket ss;
JFrame f;
 addition1()
 {

 }
 public void func()
 {
   f =new JFrame("user 1");//Frame for Client
  f.setLayout(new FlowLayout());//set layout
  //f.setBackground(Color.red);//set background color of the Frame

  f.addWindowListener(new W1());//add Window Listener to the Frame
  tf=new JTextField(32);
  ta=new JTextArea(40,40);
  b.setBackground(Color.gray);
  b.setForeground(Color.black);
  ta.setBackground(Color.lightGray );
  tf.setBackground(Color.lightGray );
  f.add(tf);//Add TextField to the frame
  f.add(b);//Add send Button to the frame
  f.add(ta);//Add TextArea to the frame
  f.getRootPane().setDefaultButton(b);

    try
    {
    ss=new ServerSocket(6000);   
    }
    catch(Exception e)  
    {
    }
  th=new Thread(this);//start a new thread
  th.setDaemon(true);//set the thread as demon
  th.start();
  setFont(new Font("Arial",Font.BOLD,20));
  f.setSize(500,500);//set the size
  f.setVisible(true);
  f.setLocation(100,300);//set the location
  f.validate();
 }
 //method required to close the Frame on clicking "X" icon.
 private class W1 extends WindowAdapter
 {
  public void windowClosing(WindowEvent we)
  {
   System.exit(0);
  }
 }
 //Thread running as a process in background
 public void run()
 {
  while(true)
  {
   try{
           s=new Socket("localhost",6990);
      br=new BufferedReader(new InputStreamReader(s.getInputStream()));
    ta.append(br.readLine()+"\n");//Append to TextArea
   }catch(Exception e) {}
  }
 }
}