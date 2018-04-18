/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Setup;

import Connections.SQLiteConnection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ht3000052
 */
public class SetupSQLite extends SQLiteConnection {
    
    public SetupSQLite()
    {
        init();
    }
    
    private void init()
    {
        //dropTables();
        createCustomerTable();
        createAdminTable();
        createCategoryTable();
        inserts();
    }
    
    private void dropTables()
    {
        String SQL = "drop table Customer; drop table Admin;";
         boolean conectou = false;
        
        try{
            conectou = this.connect();
            
            Statement stm = this.con.createStatement();
            
            stm.execute(SQL);
            
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
    
    private void createCustomerTable()
    {
         String sql = "CREATE TABLE IF NOT EXISTS Customers("
                      + "id INTEGER primary key AUTOINCREMENT not null,"
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
    
    private void inserts()
    {
        String SQL = "INSERT INTO Customers(name,document,phone,email) VALUES ('Sara','12345','789456','email@email.com')";
        
         boolean conectou = false;
        
        try{
            conectou = this.connect();
            
            Statement stm = this.con.createStatement();
            
            stm.execute(SQL);
            
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
    
    private void createAdminTable()
    {
         String sql = "CREATE TABLE IF NOT EXISTS Admin("
                      + "id INTEGER primary key AUTOINCREMENT not null,"
                      + "document varchar(20) unique not null, "                      
                      + "password varchar(20) not null)";
        
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
    
    private void createCategoryTable()
    {
         String sql = "CREATE TABLE IF NOT EXISTS Categories("
                      + "id INTEGER primary key AUTOINCREMENT not null,"
                      + "name varchar(255) not null)";
        
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
