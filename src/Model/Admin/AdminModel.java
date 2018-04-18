/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Admin;

import Connections.ConnectionFactory;
import Connections.SQLiteConnection;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ht3000052
 */
public class AdminModel extends Admin{
    
    public AdminModel()
    {
        super("`admin`");        
    }
    
    public Admin find(String document) throws SQLException
    {
        Admin a = null;
                        
        SQLiteConnection sqlite = new SQLiteConnection();
        Connection con          = sqlite.getConnection();
        PreparedStatement stm = null;
        ResultSet           rs = null;
        try{
            
            stm = con.prepareStatement("SELECT * FROM "+this.Table+" WHERE document = "+document);
            //System.out.println(stm.toString());            
            //stm.setString(2, document);            
            
        
            rs = stm.executeQuery();
            rs.next();
            a = new Admin();
            a.setDocument(rs.getString("document"));            
            a.setPassword(rs.getString("password"));
            
            if(a.getDocument() == null)
            {
                return null;
            }
            
            return a;
        }catch(SQLException e){
            System.out.println("ERRO aaaaa");
            //Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        con.close();
        stm.close();
        
        return a;
    }
}
