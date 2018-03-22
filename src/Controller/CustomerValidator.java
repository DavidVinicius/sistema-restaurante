/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import javax.swing.JOptionPane;

/**
 *
 * @author ht3000052
 */
public class CustomerValidator extends Customer{
    
    public CustomerValidator()
    {
        super();
    }
    
    public CustomerValidator(String name, String document, String email,String phone)
    {
        super(name,document,email,phone);
    }
    
    public boolean isNameValid()
    {
        if(this.getName().length() < 3)
        {
            JOptionPane.showMessageDialog(null, "O nome deve possuir no mínimo 3 caracteres", "Erro no Nome", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        
        return true;
    }
    
    public boolean isDocumentValid()
    {
        String pattern = "^[./-]$";
        
        if(this.getDocument()== null)
        {
            return false;
        }
        
        if(this.getDocument().matches(pattern))
        {
            JOptionPane.showMessageDialog(null, "No campo do document não deve possuir pontos ou traços", "Erro no Documento", JOptionPane.ERROR_MESSAGE, null);
            return false;
            
        }
        return true;
    }
}
