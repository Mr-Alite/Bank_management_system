-- This is main Frame interface 
package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,ministate,pinchange,fastcash,balance,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,17));
        image.add(text);
        
        deposit = new JButton(" Cash Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Cash withdrawl");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate = new JButton("Statement Slip");
        ministate.setBounds(355,450,150,30);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if (ae.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balance){
            setVisible(false);
            new BalanceEnq(pinnumber).setVisible(true);            
        }else if (ae.getSource() == ministate){
            
            new Ministatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
    
}
-----------------------------------------------------------------------------------------
-- This frame for Cash deposit

package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    
    Deposit(String pinnumber){
    
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image); 
        
        JLabel text = new JLabel("Enter the amount you to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
         amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(170,400,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         back = new JButton("Back");
        back.setBounds(340,400,150,30);
        back.addActionListener(this);
        image.add(back);
                
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
                
            }else {
                try{
                connect connect = new connect();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+"  Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                }catch (Exception e ){
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
          
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
    
}
-----------------------------------------------------------------------------------------
-- This frame for withdrawl

package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    
    
    Withdraw(String pinnumber){
    
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image); 
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
         amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdrawl = new JButton("withdraw");
        withdrawl.setBounds(170,400,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         back = new JButton("Back");
        back.setBounds(340,400,150,30);
        back.addActionListener(this);
        image.add(back);
                
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdrawl");
                
            }else {
                try{
                connect connect = new connect();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+"  Withdrawl Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                }catch (Exception e ){
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
          
    }
    
    public static void main(String args[]){
        new Withdraw("");
    }
    
}
-----------------------------------------------------------------------------------------
-- This frame for fast cash

package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,ministate,pinchange,fastcash,balance,exit;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdraw Amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,17));
        image.add(text);
        
        deposit = new JButton("Rs 100 ");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Rs 500");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate = new JButton("Rs 2000");
        ministate.setBounds(355,450,150,30);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Rs 10,000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else  {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            connect c = new connect();
            try{
               ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
               int bbalance = 0;
               while(rs.next()){
                  if (rs.getString("type").equals("Deposit")){
                      bbalance += Integer.parseInt(rs.getString("amount"));
                  } else {
                      bbalance -= Integer.parseInt(rs.getString("amount"));
                  }
               }
               
               if (ae.getSource() != exit && bbalance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               
               Date date = new Date();
               String query = "Insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs"+ amount +"   Debited Successfully");
               
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
               
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new Fastcash("");
    }
    
}
-----------------------------------------------------------------------------------------
-- This frame for Mini statement

package bank.management.sysyem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Ministatement extends JFrame{

    
    
    Ministatement(String pinnumber){
        setTitle("MINI STATEMENT");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card =  new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            connect connect = new connect();
            ResultSet rs = connect.s.executeQuery("Select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:  " + rs.getString("cardNumber").substring(0,4) + "xxxxxxxx" + rs.getString("cardNumber").substring(12));
            }
            
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{
            connect connect = new connect();
            int bal = 0;
            ResultSet rs  = connect.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
            while (rs.next()){
               mini.setText(mini.getText() + "<html>" + rs.getString("date") +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
               if (rs.getString("type").equals("Deposit")){
                      bal += Integer.parseInt(rs.getString("amount"));
                  } else {
                      bal -= Integer.parseInt(rs.getString("amount"));
                  }
            }
            
            balance.setText("Your current account Balance is Rs " + bal);
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(20,20);
        //setUndecorated(true);
        getContentPane().setBackground(new Color(205,218,253));
        setVisible(true);
    }
    
public static void main(String args[]){
    new Ministatement("");
}    
}
-----------------------------------------------------------------------------------------
-- This frame for pin change

package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Pinchange  extends JFrame implements ActionListener {
    
    JPasswordField pin, repin;
    JButton change,back;
    String pinnumber;
    
    Pinchange(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,20);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New Pin");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,20);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355,405,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(185,405,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
            
                if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                return;
                }
            
               if (npin.equals("")) {
               JOptionPane.showMessageDialog(null, " Enter New Pin");
                return; 
               }
            
               if (rpin.equals("")){
                JOptionPane.showMessageDialog(null, " Re-Enter Pin");
                return;
               }
            
            
              connect connect = new connect();
              String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
              String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
              String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            
              connect.s.executeUpdate(query1);
              connect.s.executeUpdate(query2);
              connect.s.executeUpdate(query3);
            
              JOptionPane.showMessageDialog(null, " Pin changed Successfully");
            
              setVisible(false);
              new Transactions(rpin).setVisible(true);
            
           }catch (Exception e){
            System.out.println(e);
           }
          } else {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
    }
    
    public static void main(String args[]){
        new Pinchange("").setVisible(true);
    }
    
}
-----------------------------------------------------------------------------------------
-- This frame for balance enquiry
package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;

public class BalanceEnq extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    
    BalanceEnq(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        connect c = new connect();
        int bbalance = 0;
            try{
                 ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                 
                 while(rs.next()){
                  if (rs.getString("type").equals("Deposit")){
                      bbalance += Integer.parseInt(rs.getString("amount"));
                  } else {
                      bbalance -= Integer.parseInt(rs.getString("amount"));
                  }
                 }
               } catch (Exception e){
                       System.out.println(e);
                       }
            
            JLabel text = new JLabel("Your Current Account Balance is Rs  " +bbalance);
            text.setForeground(Color.WHITE);
            text.setBounds(170,300,400,30);
            image.add(text);
            
            
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnq("");
    }
}
-----------------------------------------------------------------------------------------

 
