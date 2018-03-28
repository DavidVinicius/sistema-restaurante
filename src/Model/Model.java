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

/**
 *
 * @author ht3000052
 */
public abstract class Model {
    private static String Table;
    
    
    
    public static int count(String field, String param) throws SQLException
    {
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        
        stm = con.prepareStatement("SELECT count(*) as total FROM ? WHERE ? = ?");
        stm.setString(1, Table);
        stm.setString(2, field);
        stm.setString(2, param);
        
        try{
            rs = stm.executeQuery();
            rs.next();
            
            int total = rs.getInt("total");
            
            return total;
        }catch(SQLException e){
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int count() throws SQLException
    {
        Connection con        = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        
        stm = con.prepareStatement("SELECT count(*) as total FROM ? ");
        stm.setString(1, Table);
        System.out.println(stm.toString());
         try{
            rs = stm.executeQuery();
            rs.next();
            
            int total = rs.getInt("total");
            
            return total;
        }catch(SQLException e){
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         return 0;
    }
}
