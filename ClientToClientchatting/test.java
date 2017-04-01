import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;
class test
{
	public static void main(String[] args)
	{
	JFrame f=new JFrame("user 1");//Frame for Server
  f.setLayout(new FlowLayout());//set layout
  //f.setBackground(Color.orange);//set background color of the Frame
  JButton b1=new JButton("Send");//Send Butto

  // b1.addActionListener(this);//Add action listener to send button.
  // ta.setBackground(Color.cyan);
 
  f.add(b1);//Add send Button to the frame
 f.setSize(500,500);//set the size
  f.setLocation(300,300);//set the location
  f.setVisible(true);
  f.validate();
  b1.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e)
    { System.out.println("helo"); }
});
	}
}