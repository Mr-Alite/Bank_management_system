// This code is for connecting java and Mysql we also called JDBC
package bank.management.sysyem;

import java.sql.*;

public class connect 
{
    Connection c;
    Statement s;
    public connect()
    {
        try {
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Mysql4u");
            s = c.createStatement();
        } catch (Exception e)
        {
           System.out.println(e); 
        }
    }
    
}
