/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.ParseException;
import Model.Customer;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ht3000052
 */
public class CustomerValidator extends Customer {

    public CustomerValidator() {
        super();
    }

    public CustomerValidator(String name, String document, String email, String phone) {
        super(name, document, email, phone);
    }

    public boolean isNameValid() {
        if (this.getName().length() < 3) {
            JOptionPane.showMessageDialog(null, "O nome deve possuir no mínimo 3 caracteres", "Erro no Nome", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        return true;
    }

    public boolean isPhoneValid() {
        if (this.getPhone().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo Telefone não pode estar em branco! ", "Erro no Telefone", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }

        return true;
    }

    public boolean isDocumentValid() {

        if (this.getDocument().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo CPF deve estar preenchido! ", "Erro no CPF", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        return true;
    }

 /*   public boolean requiredMail() {

        if (this.getEmail().indexOf('@') == -1){
            
        }    
         
        
        return true;
    }
*/
}
