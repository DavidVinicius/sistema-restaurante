/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Admin.Category;
import javax.swing.JOptionPane;

/**
 *
 * @author ht3000052
 */
public class CategoryValidator extends Category {
    
    public CategoryValidator(String name)
    {
        super(name);
    }
    
    public boolean isNameValid()
    {
        if(this.name.length() < 4)
        {
            JOptionPane.showMessageDialog(null,"O nome deve possuir mais de 4 caracteres");
            return false;
        }
                
        return true;
    }
}
