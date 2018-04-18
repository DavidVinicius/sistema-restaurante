/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Admin;

/**
 *
 * @author ht3000052
 */
public class Admin {
    protected String Table = "`Admin`";
    protected String document;
    protected String password;
    
    public Admin()
    {
    }
    
    public Admin(String table)
    {
        this.Table = table;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
