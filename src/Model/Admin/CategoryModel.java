/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Admin;

import Connections.ConnectionFactory;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ht3000052
 */
public class CategoryModel extends Category{
    private String nameField = "name";
    private String idField  = "id";
    
    public boolean create(Category c) throws SQLException
    {
        Connection          con  = ConnectionFactory.getConnection();
        PreparedStatement   stm  = null;
        ResultSet           rs   = null;
        try{
            String fields = nameField;
            stm = con.prepareStatement("INSERT INTO "+ Table +" ("+fields+") VALUES (?)");
            stm.setString(1,c.getName());                    
            stm.executeUpdate();            
            
            return true;
        }catch(SQLException e){
            
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.close();
            stm.close();
        }
        
        
        return false;
    }
    
     public Category[] where(String field,String opt,String arg) throws SQLException
    {
        Category[] c = null;
        
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        try{
            
            stm = con.prepareStatement("SELECT * FROM "+Table+" WHERE `"+field+"` "+opt+" "+arg);                                                
            rs = stm.executeQuery();            
            rs.last();
            int total = rs.getRow();
            c = new Category[total];
            
            rs.beforeFirst();            
            int i = 0;
            while(rs.next())
            {
                Category category = new Category();
                category.setId(rs.getInt(idField));
                category.setName(rs.getString(nameField));                                
                c[i] = category;
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
     
     public Category[] all() throws SQLException
    {
        Category[] c = null;
        
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        try{
            
            stm = con.prepareStatement("SELECT * FROM "+Table);                                                            
            
            rs = stm.executeQuery();            
            rs.last();
            int total = rs.getRow();
            //System.out.println(total);
            c = new Category[total];
            
            rs.beforeFirst();            
            int i = 0;
            while(rs.next())
            {
                
                Category category = new Category();
                category.setId(rs.getInt(idField));
                category.setName(rs.getString(nameField));                                
                
                c[i] = category;
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
}
