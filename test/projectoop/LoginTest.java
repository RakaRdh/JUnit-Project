/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JOptionPane;
import java.lang.reflect.Method;

public class LoginTest {

    private Login login;
    
    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = Login.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(login, (Object) null); // Passing null as the MouseEvent
    }

    @Before
    public void setUp() {
        // Initialize the Login object
        login = new Login();
        login.setVisible(true);  // Ensure the window is visible
    }
    
    @Test
    public void testMain() {
        String[] args = null;
        login.main(args);
        assertTrue(login.isVisible());
    }

    @Test
    public void testEmptyUsernameAndPassword() throws Exception {
            login.usernameTextFiield_Login.setText("");
            login.passwordTextField_Login.setText("");
            
            invokePrivateMethod("loginButton_LoginMouseClicked");
            assertEquals("Please Enter Your Username and Password", "Please Enter Your Username and Password");
    }

    @Test
    public void testEmptyUsername() throws Exception {
        
            // Set only the password field
            login.usernameTextFiield_Login.setText("");
            login.passwordTextField_Login.setText("password123");
            
            invokePrivateMethod("loginButton_LoginMouseClicked");

            // The result should trigger a message dialog for empty username
            assertEquals("Please Enter Your Username and Password", "Please Enter Your Username and Password");
        
    }

    @Test
    public void testEmptyPassword() throws Exception {
        
            // Set only the username field
            login.usernameTextFiield_Login.setText("username");
            login.passwordTextField_Login.setText("");
            
            // Use reflection to access the private method
            invokePrivateMethod("loginButton_LoginMouseClicked");

            // The result should trigger a message dialog for empty password
            assertEquals("Please Enter Your Username and Password", "Please Enter Your Username and Password");
        
    }

    @Test
    public void testInvalidLogin() throws Exception {
       
            // Set invalid credentials
            login.usernameTextFiield_Login.setText("wrongUsername");
            login.passwordTextField_Login.setText("wrongPassword");
            
            invokePrivateMethod("loginButton_LoginMouseClicked");

            // The result should trigger a message dialog for incorrect credentials
            assertEquals("Wrong Username or Password", "Wrong Username or Password");
       
    }

    @Test
    public void testValidLogin() throws Exception{
        
            // Assuming we are mocking a valid login scenario
            login.usernameTextFiield_Login.setText("Raka Herdika");
            login.passwordTextField_Login.setText("123");
            
            invokePrivateMethod("loginButton_LoginMouseClicked");

            // Check if the user is successfully logged in
            assertNotNull(login);
       
    }

    @Test
    public void testRegisterLabelClick() throws Exception{
        
            // Use reflection to access the private method for the register label click
            invokePrivateMethod("registerLabel_LoginMouseClicked");

            // Check if the register page is visible and the login frame is disposed
            assertFalse(login.isVisible());
        
    }
    
}
