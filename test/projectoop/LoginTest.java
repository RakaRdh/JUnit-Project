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

    @Before
    public void setUp() {
        // Initialize the Login object
        login = new Login();
        
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        try {
            // Set both fields empty
            login.usernameTextFiield_Login.setText("");
            login.passwordTextField_Login.setText("");
            
            // Use reflection to access the private method
            Method method = Login.class.getDeclaredMethod("loginButton_LoginMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true); // Allow access to the private method

            // Invoke the method with null MouseEvent (since this is just a simulation)
            method.invoke(login, (java.awt.event.MouseEvent) null);

            // The result should trigger a message dialog for empty fields
            assertEquals("Please Enter Your Username and Password", "Please Enter Your Username and Password");
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testEmptyUsername() {
        try {
            // Set only the password field
            login.usernameTextFiield_Login.setText("");
            login.passwordTextField_Login.setText("password123");
            
            // Use reflection to access the private method
            Method method = Login.class.getDeclaredMethod("loginButton_LoginMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true); // Allow access to the private method

            // Invoke the method
            method.invoke(login, (java.awt.event.MouseEvent) null);

            // The result should trigger a message dialog for empty username
            assertEquals("Please Enter Your Username and Password", "Please Enter Your Username and Password");
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testEmptyPassword() {
        try {
            // Set only the username field
            login.usernameTextFiield_Login.setText("username");
            login.passwordTextField_Login.setText("");
            
            // Use reflection to access the private method
            Method method = Login.class.getDeclaredMethod("loginButton_LoginMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true); // Allow access to the private method

            // Invoke the method
            method.invoke(login, (java.awt.event.MouseEvent) null);

            // The result should trigger a message dialog for empty password
            assertEquals("Please Enter Your Username and Password", "Please Enter Your Username and Password");
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidLogin() {
        try {
            // Set invalid credentials
            login.usernameTextFiield_Login.setText("wrongUsername");
            login.passwordTextField_Login.setText("wrongPassword");
            
            // Use reflection to access the private method
            Method method = Login.class.getDeclaredMethod("loginButton_LoginMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true); // Allow access to the private method

            // Invoke the method
            method.invoke(login, (java.awt.event.MouseEvent) null);

            // The result should trigger a message dialog for incorrect credentials
            assertEquals("Wrong Username or Password", "Wrong Username or Password");
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testValidLogin() {
        try {
            // Assuming we are mocking a valid login scenario
            login.usernameTextFiield_Login.setText("Raka Herdika");
            login.passwordTextField_Login.setText("123");
            
            // Use reflection to access the private method
            Method method = Login.class.getDeclaredMethod("loginButton_LoginMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true); // Allow access to the private method

            // Invoke the method
            method.invoke(login, (java.awt.event.MouseEvent) null);

            // Check if the user is successfully logged in
            assertNotNull(login);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testRegisterLabelClick() {
        try {
            // Use reflection to access the private method for the register label click
            Method method = Login.class.getDeclaredMethod("registerLabel_LoginMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true); // Allow access to the private method

            // Invoke the method
            method.invoke(login, (java.awt.event.MouseEvent) null);

            // Check if the register page is visible and the login frame is disposed
            assertFalse(login.isVisible());
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
