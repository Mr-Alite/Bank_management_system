-----------------------------------------------------------------------------------------
// This is 1st class for signup
package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener
{
    long random;
    JTextField NameTextField, fnameTextField, emailTextField, AdrTextField, cityTextField, stateTextField, pinTextField; 
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    Signup1() {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L)+1000L;
        
        JLabel formNo = new JLabel("APPLICATION NO:"+ random);
        formNo.setFont(new Font("vardana",Font.BOLD,38));
        formNo.setBounds(170,80,660,40);
        add(formNo);
        
        JLabel PersonalDetails = new JLabel("Page 1: Personal Details");
        PersonalDetails.setFont(new Font("vardana",Font.BOLD,25));
        PersonalDetails.setBounds(240,100,600,90);
        add(PersonalDetails);
        
        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("vardana",Font.BOLD,20));
        Name.setBounds(90,220,90,30);
        add(Name);
        
        NameTextField = new JTextField();
        NameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        NameTextField.setBounds(300,220,260,30);
        add(NameTextField);
        
        JLabel  fname = new JLabel("Father Name:");
        fname.setFont(new Font("vardana",Font.BOLD,20));
        fname.setBounds(90,260,150,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBounds(300,260,260,30);
        add(fnameTextField);
        
        JLabel  dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("vardana",Font.BOLD,20));
        dob.setBounds(90,300,150,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,300,120,30);
        add(dateChooser);
        
        JLabel  gender = new JLabel("Gender:");
        gender.setFont(new Font("vardana",Font.BOLD,20));
        gender.setBounds(90,340,150,30);
        add(gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(300,340,60,30);
        male.setBackground(new Color(205,218,253));
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(380,340,80,30);
        female.setBackground(new Color(205,218,253));
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel  email = new JLabel("Email:");
        email.setFont(new Font("vardana",Font.BOLD,20));
        email.setBounds(90,420,150,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(300,420,260,30);
        add(emailTextField); 
        
        JLabel  Mstatus = new JLabel("Marital Status:");
        Mstatus.setFont(new Font("vardana",Font.BOLD,20));
        Mstatus.setBounds(90,380,150,30);
        add(Mstatus);
        
        married = new JRadioButton("MARRIED");
        married.setBounds(300,380,83,30);
        married.setBackground(new Color(205,218,253));
        add(married);
        
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(380,380,100,30);
        unmarried.setBackground(new Color(205,218,253));
        add(unmarried);
        
        other = new JRadioButton("OTHER");
        other.setBounds(480,380,90,30);
        other.setBackground(new Color(205,218,253));
        add(other);
        
        ButtonGroup Mstatusgroup = new ButtonGroup();
        Mstatusgroup.add(married);
        Mstatusgroup.add(unmarried);
        Mstatusgroup.add(other);
        
        JLabel  Adr = new JLabel("Address:");
        Adr.setFont(new Font("vardana",Font.BOLD,20));
        Adr.setBounds(90,460,150,30);
        add(Adr);
        
        AdrTextField = new JTextField();
        AdrTextField.setFont(new Font("Raleway", Font.BOLD,14));
        AdrTextField.setBounds(300,460,260,30);
        add(AdrTextField);
        
        JLabel  city = new JLabel("City:");
        city.setFont(new Font("vardana",Font.BOLD,20));
        city.setBounds(90,500,150,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(300,500,260,30);
        add(cityTextField);
        
        
        JLabel  state = new JLabel("State:");
        state.setFont(new Font("vardana",Font.BOLD,20));
        state.setBounds(90,540,150,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(300,540,260,30);
        add(stateTextField);
        
        JLabel  pincode = new JLabel("Pin code:");
        pincode.setFont(new Font("vardana",Font.BOLD,20));
        pincode.setBounds(90,580,150,30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(300,580,260,30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(300,620,80,40);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(new Color(205,218,253));
        setSize(750, 780);
        setLocation(350, 10);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formNo = "" + random;
        String Name = NameTextField.getText(); // setText
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String Mstatus = null;
        if (married.isSelected()){
           Mstatus = "married"; 
        } else if (unmarried.isSelected()){
            Mstatus = "Unmarried";
        } else if (other.isSelected()){
            Mstatus = "Other";
        }
        String Adr = AdrTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try {
            if (Name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                connect c = new connect();
                String query = "insert into signup values('"+formNo+"','"+Name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+Mstatus+"','"+Adr+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup2(formNo).setVisible(true);
                
                


            }
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
    //
     
    
    
    public static void main(String args[]) 
    {
        new Signup1();
    }
}
-----------------------------------------------------------------------------------------
// This is 2nd class for signup
package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener
{
    
    JTextField pan, aadhar; 
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox religion,category,occupation,education,income;
    String formNo;
    Signup2(String formNo) {
        this.formNo = formNo;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel addtionalDetails= new JLabel("PAGE 2:  Additonal Details");
        addtionalDetails.setFont(new Font("vardana",Font.BOLD,25));
        addtionalDetails.setBounds(240,60,600,90);
        add(addtionalDetails);
        
        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("vardana",Font.BOLD,20));
        Religion.setBounds(90,200,90,30);
        add(Religion);
        
        String ValReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(ValReligion);
        religion.setBounds(300,200,260,30);
        add(religion);
      
        JLabel  Category = new JLabel("Category:");
        Category.setFont(new Font("vardana",Font.BOLD,20));
        Category.setBounds(90,245,150,30);
        add(Category);
        
        String Valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(Valcategory);
        category.setBounds(300,245,260,30);
        add(category);
        
        JLabel  Income = new JLabel("Income:");
        Income.setFont(new Font("vardana",Font.BOLD,20));
        Income.setBounds(90,290,260,30);
        add(Income);
        
        String incomecategory[] = {"Null","< 1,50,000","< 2,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,290,260,30);
        add(income);
       
        JLabel  Education = new JLabel("Education");
        Education.setFont(new Font("vardana",Font.BOLD,20));
        Education.setBounds(90,320,150,30);
        add(Education);
        
        
        JLabel  Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("vardana",Font.BOLD,20));
        Qualification.setBounds(90,345,150,30);
        add(Qualification);
        
        String educationVal[] = {"Non-graduation","Graduation","Post-Graduation","Doctrate","Other"};
        education = new JComboBox(educationVal);
        education.setBounds(300,345,260,30);
        add(education);
        
        JLabel  Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("vardana",Font.BOLD,20));
        Occupation.setBounds(90,390,150,30);
        add(Occupation);
        
        String occupationVal[] = {"Salaried","Self-employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occupationVal);
        occupation.setBounds(300,390,260,30);
        add(occupation);
        
        JLabel  Adr = new JLabel("PAN no:");
        Adr.setFont(new Font("vardana",Font.BOLD,20));
        Adr.setBounds(90,435,150,30);
        add(Adr);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,435,260,30);
        add(pan);
        
        JLabel  aahar = new JLabel("Aadhar no:");
        aahar.setFont(new Font("vardana",Font.BOLD,20));
        aahar.setBounds(90,480,150,30);
        add(aahar);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD,14));
        aadhar.setBounds(300,480,260,30);
        add(aadhar);
        
        
        JLabel  state = new JLabel("Senior Citizen:");
        state.setFont(new Font("vardana",Font.BOLD,20));
        state.setBounds(90,520,150,30);
        add(state);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300,520,83,30);
        syes.setBackground(new Color(205,218,253));
        add(syes); 
        
        sno = new JRadioButton("NO");
        sno.setBounds(380,520,100,30);
        sno.setBackground(new Color(205,218,253));
        add(sno);
        
        ButtonGroup Mstatusgroup = new ButtonGroup();
        Mstatusgroup.add(syes);
        Mstatusgroup.add(sno);
        
        JLabel  pincode = new JLabel("Exisiting Account:");
        pincode.setFont(new Font("vardana",Font.BOLD,20));
        pincode.setBounds(70,557,180,30);
        add(pincode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300,560,83,30);
        eyes.setBackground(new Color(205,218,253));
        add(eyes); 
        
        eno = new JRadioButton("NO");
        eno.setBounds(380,560,100,30);
        eno.setBackground(new Color(205,218,253));
        add(eno);
        
        ButtonGroup eMstatusgroup = new ButtonGroup();
        eMstatusgroup.add(eyes);
        eMstatusgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(300,600,80,40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(new Color(205,218,253));
        setSize(750, 780);
        setLocation(350, 10);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion =(String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "Yes";
        } else if (sno.isSelected()){
            seniorcitizen = "NO";
        }
        String exisitingaccouont = null;
        if (eyes.isSelected()){
           exisitingaccouont = "Yes"; 
        } else if (eno.isSelected()){
            exisitingaccouont = "Unmarried";
        } else if (eno.isSelected()){
            exisitingaccouont = "Other";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try {
                connect c = new connect();
                String query = "insert into signup2 values('"+formNo+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccouont+"')";
                c.s.executeUpdate(query);
                // Signup3 object
                setVisible(false);
                new Signup3(formNo).setVisible(true);
             } catch (Exception e){
            System.out.println(e);
        }
        
    }
     
    
    
    public static void main(String args[]) 
    {
        new Signup2("");
    }
}
-----------------------------------------------------------------------------------------
// This 3rd class for signup
package bank.management.sysyem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;
    
    Signup3(String formNo){
        this.formNo = formNo;
        setLayout(null);
        
        JLabel l1 = new JLabel("PAGE 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,25));
        l1.setBounds(230,30,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(90,90,400,40);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Releway",Font.BOLD,16));
        r1.setBackground(new Color(205,218,253));
        r1.setBounds(100,125,150,90);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Releway",Font.BOLD,16));
        r2.setBackground(new Color(205,218,253));
        r2.setBounds(100,185,200,90);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Releway",Font.BOLD,16));
        r3.setBackground(new Color(205,218,253));
        r3.setBounds(350,125,150,90);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Releway",Font.BOLD,16));
        r4.setBackground(new Color(205,218,253));
        r4.setBounds(350,185,250,90);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD,25));
        card.setBounds(100,285,300,40);
        add(card);
        
        JLabel number = new JLabel("xxxx-xxxx-xxxx-2954");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330,285,300,40);
        add(number);
        
        JLabel carddetail = new JLabel("YOUR CARD NUMBER");
        carddetail.setFont(new Font("Raleway", Font.BOLD,13));
        carddetail.setBounds(100,305,300,40);
        add(carddetail);
        
        JLabel pin = new JLabel("Pin Number");
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(100,355,300,40);
        add(pin);
        
        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD,22));
        pnumber.setBounds(330,355,300,40);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway", Font.BOLD,13));
        pindetail.setBounds(100,375,300,40);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD,22));
        services.setBounds(90,435,300,40);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
         c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(400,500,200,30);
        add(c2);
        
         c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
         c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(400,550,200,30);
        add(c4);
        
         c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
         c6 = new JCheckBox("Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(400,600,200,30);
        add(c6);
        
         c7 = new JCheckBox("I confirm the above information is accurate to my best knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,15));
        c7.setBounds(93,650,515,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD,14));
        submit.setBounds(220,700,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD,14));
        cancel.setBounds(380,700,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(750,790);
        getContentPane().setBackground(new Color(205,218,253));
        setLocation(350,0);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accountType = null;
        if (r1.isSelected()){
            accountType = "Saving Account";
            
        }else if(r2.isSelected()){
            accountType = "Fixed Deposit Account";
        }else if(r3.isSelected()){
            accountType = "Current Account";
        }else if(r4.isSelected()){
            accountType = "Reccuring Deposit Account";
        }
       
        Random random = new Random();
        String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)+ 5040893000000000L);
        
        String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
        
        String facility = "";
        if (c1.isSelected()){
            facility = facility + "ATM CARD";
        }else if (c2.isSelected()){
            facility = facility + "Internet Banking";
        }else if (c3.isSelected()){
            facility = facility + "Mobile Banking";
        }else if (c4.isSelected()){
            facility = facility + "Email & SMS Alerts";
        }else if (c5.isSelected()){
            facility = facility + "Cheque Book";
        }else if (c6.isSelected()){
            facility = facility + "E-Statement";
        }
        
        try {
            if (accountType.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is Required");
            }else {
                connect connect = new connect();
                String query1 = "insert into signup3 values('"+formNo+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2 = "insert into login values('"+formNo+"','"+cardnumber+"','"+pinnumber+"')";
                connect.s.executeUpdate(query1);
                connect.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Card number:" + cardnumber + "\n pin:" + pinnumber );
           
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
                
            
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
    }else if (ae.getSource() == cancel){
        setVisible(false);
        new Login().setVisible(true);
    }
}
    public static void main(String args[])
    {
        new Signup3("");
    }
    
}
-----------------------------------------------------------------------------------------