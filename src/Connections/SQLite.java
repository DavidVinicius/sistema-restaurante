/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ht3000052
 */
public class SQLite extends ConnectionDataBase{

    public SQLite()
    {
        this.URL    = "jdbc:sqlite:banco/DB.db";
        this.DRIVER = "org.sqlite.JDBC";
        this.init();
    }
              

    @Override
    public Connection getConnection() {
        if(this.con != null)                      
        {
            return this.con;         
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
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    private void init()
    {
        createCustomerTable();
    }
    
    private void createCustomerTable()
    {
         String sql = "CREATE TABLE IF NOT EXISTS Customer("
                      + "id int auto_increment primary key not null,"
                      + "name varchar(100) not null,"
                      + "document varchar(20) unique not null,"
                      + "phone varchar(20),"
                      + "email varchar(100) unique not null);";
        
        //Executando SQL
        boolean conectou = false;
        
        try{
            conectou = this.connect();
            
            Statement stm = this.con.createStatement();
            
            stm.execute(sql);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(conectou)
            {
                this.desconnect();
            }
        }
    }
    
}
