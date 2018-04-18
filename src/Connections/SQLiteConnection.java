/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ht3000052
 */
public class SQLiteConnection extends ConnectionDataBase{
    
    protected Connection con;

    public SQLiteConnection()
    {
        this.URL    = "jdbc:sqlite:banco/DB.db";
        this.DRIVER = "org.sqlite.JDBC";        
    }
              

    @Override
    public Connection getConnection() {
        if(this.con != null)                      
        {
            
            return this.con;         
        }else{
            if(this.connect())
            {
                return this.con;
            }
            
        }
        return null;     
    }

    @Override
    public boolean connect() {
        try{
            Class.forName(this.DRIVER);
            String url = this.URL;
            
          this.con = DriverManager.getConnection(url);
          return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean desconnect() {
        try {
            if(this.con.isClosed())
            {
                
                this.con.close();
                return true;                               
            }
        } catch (SQLException ex) {            
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }                    
    
    
    
}
