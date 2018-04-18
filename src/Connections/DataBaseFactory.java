/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

/**
 *
 * @author ht3000052
 */
public class DataBaseFactory {
    
    public static ConnectionDataBase getInstance(String database)
    {
        switch(database)
        {
            case "SQLite":
                return new SQLiteConnection();
            case "MySQL":
                return new MySQL();
            default:
                return null;
        }             
    }
}
