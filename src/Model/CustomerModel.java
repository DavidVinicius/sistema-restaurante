/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ht3000052
 */
public class CustomerModel {
   static Customer customer;
   private static String Table         = "`customer`";
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
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
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
        }
        con.close();
        stm.close();
        
        return customer;
    }
    
    public static Customer where(String field,String arg) throws SQLException
    {
        Customer customer = new Customer();
        
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        try{
            stm = con.prepareStatement("SELECT * FROM "+Table+" WHERE `"+field+"` = "+arg+" ");     
            
            //System.out.println(stm.toString());
            
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
        }
        
        return null;
    }
    
    public static Customer[] where(String field,String opt,String arg) throws SQLException
    {
        Customer[] c = null;
        
        Connection con        = ConnectionFactory.getConnection();
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
        }
        
        return c;
    }
    
    
    
    public static boolean create(Customer customer) throws SQLException
    {        
        Connection          con  = ConnectionFactory.getConnection();
        PreparedStatement   stm  = null;
        ResultSet           rs   = null;
        try{
            String fields = nameField+","+emailField+","+documentField+","+phoneField;
            stm = con.prepareStatement("INSERT INTO "+ Table +" ("+fields+") VALUES (?,?,?,?)");
            stm.setString(1,customer.getName());
            stm.setString(2,customer.getEmail());
            stm.setString(3,customer.getDocument());
            stm.setString(4,customer.getPhone());
        
            stm.executeUpdate();            
            
            return true;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.close();
        stm.close();
        
        return false;
    }
}
