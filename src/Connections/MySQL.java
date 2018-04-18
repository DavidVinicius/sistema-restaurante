/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ht3000052
 */
public class MySQL extends ConnectionDataBase {
    
    private String USER;
    private String PASS;
    
     public MySQL()
     {
        this.DRIVER  = "com.mysql.jdbc.Driver";
        this.URL     = "jdbc:mysql://localhost:3306/tarefa";
        this.USER    = "root";
        this.PASS    = "123"; // alterar senha
     }
       

    @Override
    public boolean connect() {
        try {
        Class.forName(DRIVER);
            this.con = DriverManager.getConnection(URL, USER, PASS);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
            
        }        
        
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
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public Connection getConnection() {
        return this.con;
    }

    
    
}
