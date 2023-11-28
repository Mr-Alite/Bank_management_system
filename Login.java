
package bank.management.sysyem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.sql.*;

public class Login extends JFrame implements ActionListener 
{
    JButton login, signup, clear,exit;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    Login(){
        setTitle("CASH MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(95,75,90,90);
        add(label);
        
        JLabel text = new JLabel("Hello!! ATM Access Ready");
        text.setFont(new Font("vardana",Font.BOLD,30));
        text.setBounds(240,110,400,50);
        add(text);
        
        JLabel CardNo = new JLabel("Card Number:");
        CardNo.setFont(new Font("vardana",Font.BOLD,28));
        CardNo.setBounds(90,210,300,50);
        add(CardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,220,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
       
        
        JLabel Pin = new JLabel("Pin Number:");
        Pin.setFont(new Font("vardana",Font.BOLD,28));
        Pin.setBounds(110,266,300,50);
        add(Pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,280,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,340,100,30);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(430,340,100,30);
        clear.addActionListener(this);
        add(clear); 
        
       signup = new JButton("SIGN UP");
       signup.setBounds(300,380,230,30);
       signup.addActionListener(this);
       add(signup);
       
       exit = new JButton("Exit");
       exit.setBounds(300,420,230,30);
       exit.addActionListener(this);
       add(exit);
       
        getContentPane().setBackground(new Color(205,218,253));
        
        setSize(800,500);
        setLocation(350,200);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()== clear)
       {
          cardTextField.setText("");
          pinTextField.setText("");
       }
       else if (ae.getSource() == login)
       {
         connect connect = new connect();
         String cardnumber = cardTextField.getText();
         String pinnumber = pinTextField.getText();
         String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
         try {
             ResultSet rs = connect.s.executeQuery(query);
             if (rs.next()){
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             }else {
                 JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin number");
             }
         } catch (Exception e){
             System.out.println(e);
         }
       }
       else if (ae.getSource() == signup)
       {
          setVisible(false);
          new Signup1().setVisible(true);
       }else if (ae.getSource() == exit){
            System.exit(0);
        }
    }
    public static void main(String args[]){
     new Login();   
    }
    
}
