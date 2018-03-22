/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ht3000052
 */
public class Customer {

       
   private String name; 
   private String document;
   private String email;
   private String phone;   
   private boolean exists = false;
   
   public Customer(String name,String document, String email,String phone)
   {
       this.name     = name;
       this.document = document;
       this.email    = email;
       this.phone    = phone;
   }      
   
   public Customer()
   {
       
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }
   
   
}
