/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;

/**
 *
 * @author ht3000052
 */
public abstract class ConnectionDataBase {
    
    protected String DRIVER;
    protected String URL;
    protected Connection con;
    
    public abstract boolean    connect();
    public abstract boolean    desconnect();
    public abstract Connection getConnection();
}
