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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ht3000052
 */
public class CustomerModel {
    static Customer customer;
    
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
            stm = con.prepareStatement("SELECT * FROM cliente WHERE codigo = ?");
            stm.setInt(1, id);
        
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
        
        return customer;
    }
    
    public static boolean create(Customer customer) throws SQLException
    {        
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        try{
            stm = con.prepareStatement("INSERT INTO cliente (nome,email,rg,telefone) VALUES (?,?,?,?)");
            stm.setString(1,customer.name);
            stm.setString(2,customer.email);
            stm.setString(3,customer.document);
            stm.setString(4,customer.phone);
        
            stm.executeUpdate();
            
           /* customer.setName(rs.getString("nome"));
            customer.setEmail(rs.getString("email"));
            customer.setDocument(rs.getString("rg"));
            customer.setPhone(rs.getString("telefone"));*/
            
            return true;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
