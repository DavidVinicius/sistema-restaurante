package ModelTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.ConnectionFactory;
import Model.Customer;
import Model.CustomerModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ht3000052
 */
public class CustomerModelTest {
    
    public CustomerModelTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testConnectionTableCustomer() throws SQLException
    {
        Connection con = ConnectionFactory.getConnection();
        assertNotNull("Não foi possível conectar no banco de dados", con);
    }
    
    @Test
    public void testMethodWhereCustomer() throws SQLException
    {
        Customer [] c = CustomerModel.where("name", "LIKE","'%a%'");
        for(int i = 0; i < c.length; i++)
        {
            System.out.println(c[i].getName());
        }
        
        assertNotNull("Retornou vazio",c);
    }
    
    @Test
    public void testMethodWhereEqualsCustomer() throws SQLException
    {
        Customer c = CustomerModel.where("name","'Sara'");
                
        assertNotNull("Retornou vazio",c);
    }
}
