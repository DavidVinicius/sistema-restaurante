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
   private static String Table = "`cliente`";
    
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
            customer.setName(rs.getString("nome"));
            customer.setEmail(rs.getString("email"));
            customer.setDocument(rs.getString("rg"));
            customer.setPhone(rs.getString("telefone"));
            
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
        Customer customer = null;
        
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        try{
            stm = con.prepareStatement("SELECT * FROM "+Table+" WHERE `"+field+"` = ? Limit 1");            
            stm.setString(1, arg);                    
            rs = stm.executeQuery();
            
            rs.next();                        
            customer.setName(rs.getString("nome"));
            customer.setEmail(rs.getString("email"));
            customer.setDocument(rs.getString("rg"));
            customer.setPhone(rs.getString("telefone"));
            
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
                
                customer.setName(rs.getString("nome"));
                customer.setEmail(rs.getString("email"));
                customer.setDocument(rs.getString("rg"));
                customer.setPhone(rs.getString("telefone"));
                
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
            stm = con.prepareStatement("INSERT INTO cliente (nome,email,rg,telefone) VALUES (?,?,?,?)");
            stm.setString(1,customer.getName());
            stm.setString(2,customer.getEmail());
            stm.setString(3,customer.getDocument());
            stm.setString(4,customer.getPhone());
        
            stm.executeUpdate();
            
           /* customer.setName(rs.getString("nome"));
            customer.setEmail(rs.getString("email"));
            customer.setDocument(rs.getString("rg"));
            customer.setPhone(rs.getString("telefone"));*/
            
            return true;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.close();
        stm.close();
        
        return false;
    }
}
