/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connections.ConnectionFactory;
import Connections.DataBaseFactory;
import Connections.SQLiteConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLite;

/**
 *
 * @author ht3000052
 */
public class CustomerModel extends Model{
   static Customer customer;
   private static String Table         = "`Customers`";
   private static String nameField     = "name";
   private static String emailField    = "email";
   private static String documentField = "document";
   private static String phoneField    = "phone";
    
    public CustomerModel()
    {
        
    }
    
    public static Customer find(int id) throws SQLException
    {
        customer = new Customer();        
        SQLiteConnection sqlite  = new SQLiteConnection();
        Connection con           = sqlite.getConnection();
        PreparedStatement stm    = null;
        ResultSet           rs   = null;
        try{
            stm = con.prepareStatement("SELECT * FROM ? WHERE codigo = ?");
            stm.setString(1, Table);
            stm.setInt(2, id);
        
            rs = stm.executeQuery();
            rs.next();
            customer.setName(rs.getString(nameField));
            customer.setEmail(rs.getString(emailField));
            customer.setDocument(rs.getString(documentField));
            customer.setPhone(rs.getString(phoneField));
            
            return customer;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            sqlite.desconnect();
        }
        con.close();
        stm.close();
        
        return customer;
    }
    
    public static Customer where(String field,String arg) throws SQLException
    {
        Customer customer = new Customer();                
        SQLiteConnection sqlite = new SQLiteConnection();
        Connection con          = sqlite.getConnection();
        PreparedStatement stm   = null;
        ResultSet           rs  = null;
        try{
            
            stm = con.prepareStatement("SELECT * FROM "+Table+" WHERE `"+field+"` = "+arg+" ");     
            //System.out.println(con.prepareStatement("SELECT * FROM "+Table+" WHERE `"+field+"` = "+arg+" ").toString());
            
            //stm.setString(1, arg);                    
            rs = stm.executeQuery();            
            rs.next();                
            customer.setName(rs.getString(nameField));
            customer.setEmail(rs.getString(emailField));
            customer.setDocument(rs.getString(documentField));
            customer.setPhone(rs.getString(phoneField));
            customer.setExists(true);
            return customer;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            sqlite.desconnect();
        }
        
        return null;
    }
    
    public static Customer[] where(String field,String opt,String arg) throws SQLException
    {
        Customer[] c = null;
        
        
        SQLiteConnection sqlite = new SQLiteConnection();
        Connection con = sqlite.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        try{
            
            stm = con.prepareStatement("SELECT * FROM "+Table+" WHERE `"+field+"` "+opt+" "+arg);                                                
            rs = stm.executeQuery();            
            rs.last();
            int total = rs.getRow();
            c = new Customer[total];
            
            rs.beforeFirst();            
            int i = 0;
            while(rs.next())
            {
                customer = new Customer();
                
                customer.setName(rs.getString(nameField));
                customer.setEmail(rs.getString(emailField));
                customer.setDocument(rs.getString(documentField));
                customer.setPhone(rs.getString(phoneField));
                customer.setExists(true);
                c[i] = customer;
                i++;
            }
            
            //int total = rs.getInt("total");
            //System.out.println("1 - " + total);
            
            
            return c;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            sqlite.desconnect();
        }
        
        return c;
    }
    
    
    
    public static boolean create(Customer customer) throws SQLException
    {                
        SQLiteConnection sqlite = new SQLiteConnection();
        Connection con = sqlite.getConnection();        
        PreparedStatement   stm  = null;
        ResultSet           rs   = null;
        try{            
            String fields = nameField+","+emailField+","+documentField+","+phoneField;
            String SQL    = "INSERT INTO "+ Table +" ("+fields+") VALUES (?,?,?,?)";
            stm = con.prepareStatement(SQL);
            stm.setString(1,customer.getName());
            stm.setString(2,customer.getEmail());
            stm.setString(3,customer.getDocument());
            stm.setString(4,customer.getPhone());
            
            System.out.println(stm.toString());
            
            
            stm.executeUpdate();            
            
            return true;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           con.close();
           stm.close();
           sqlite.desconnect();
        }   
        
        
        
        return false;
    }
}
