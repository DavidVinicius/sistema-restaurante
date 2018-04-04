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
public class Category {
   protected String Table = "`categories`";
   protected String name;
   protected int    id;
   
   public Category()
   {
   
   }
   
   public Category(String name)
   {
       this.name = name;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }      

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
   
}
