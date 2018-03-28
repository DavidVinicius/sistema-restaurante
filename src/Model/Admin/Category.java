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
   
   public Category()
   {
   
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
   
}
