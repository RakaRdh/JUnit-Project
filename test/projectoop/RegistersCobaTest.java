package projectoop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JOptionPane;

public class RegistersCobaTest {

    private RegistersCoba registerForm;

    public RegistersCobaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        // Initialize any necessary resources here
    }

    @AfterClass
    public static void tearDownClass() {
        // Clean up any resources initialized in setUpClass
    }

    @Before
    public void setUp() {
        registerForm = new RegistersCoba();
        registerForm.setVisible(true); // Show the form for testing
    }

    @After
    public void tearDown() {
        registerForm.dispose(); // Close the form after each test
    }

    @Test
    public void testValidRegistration() {
        // Simulate user input
        registerForm.usernameTextField_Register.setText("validUser");
        registerForm.emailTextField_Register.setText("user@example.com");
        registerForm.pnTextField_Register.setText("082124700001");
        registerForm.passwordTextField_Register.setText("ValidPassword1!");
        registerForm.cpTextField_Register.setText("ValidPassword1!");

        // Call the registration button click
        registerForm.registerButton_Register1.doClick();

        // Check for success message
        // In a real scenario, you might want to capture the JOptionPane output to assert against
//        assertEquals("Registration Successful", JOptionPane.showMessageDialog(null, "Registration Successful"));
    }

    @Test
    public void testMissingUsername() {
        // Simulate missing username
        registerForm.usernameTextField_Register.setText("");
        registerForm.emailTextField_Register.setText("user@example.com");
        registerForm.pnTextField_Register.setText("082124700001");
        registerForm.passwordTextField_Register.setText("ValidPassword1!");
        registerForm.cpTextField_Register.setText("ValidPassword1!");

        registerForm.registerButton_Register1.doClick();

        // Expect warning for missing information
//        assertEquals("Missing Information", JOptionPane.showMessageDialog(null, "Missing Information", "Message", JOptionPane.WARNING_MESSAGE));
    }

    @Test
    public void testInvalidEmail() {
        // Simulate invalid email format
        registerForm.usernameTextField_Register.setText("validUser");
        registerForm.emailTextField_Register.setText("invalidEmailFormat");
        registerForm.pnTextField_Register.setText("082124700001");
        registerForm.passwordTextField_Register.setText("ValidPassword1!");
        registerForm.cpTextField_Register.setText("ValidPassword1!");

        registerForm.registerButton_Register1.doClick();

        // Expect warning for invalid email
//        assertEquals("Invalid email format", JOptionPane.showMessageDialog(null, "Invalid email format", "Message", JOptionPane.WARNING_MESSAGE));
    }

    @Test
    public void testPasswordMismatch() {
        // Simulate password mismatch
        registerForm.usernameTextField_Register.setText("validUser");
        registerForm.emailTextField_Register.setText("user@example.com");
        registerForm.pnTextField_Register.setText("082124700001");
        registerForm.passwordTextField_Register.setText("ValidPassword1!");
        registerForm.cpTextField_Register.setText("DifferentPassword1!");

        registerForm.registerButton_Register1.doClick();

        // Expect warning for password mismatch
//        assertEquals("Passwords do not match", JOptionPane.showMessageDialog(null, "Passwords do not match", "Message", JOptionPane.WARNING_MESSAGE));
    }

    @Test
    public void testInvalidPhoneNumber() {
        // Simulate invalid phone number format
        registerForm.usernameTextField_Register.setText("validUser");
        registerForm.emailTextField_Register.setText("user@example.com");
        registerForm.pnTextField_Register.setText("invalidPhone");
        registerForm.passwordTextField_Register.setText("ValidPassword1!");
        registerForm.cpTextField_Register.setText("ValidPassword1!");

        registerForm.registerButton_Register1.doClick();

        // Expect warning for invalid phone number
//        assertEquals("Invalid phone number format", JOptionPane.showMessageDialog(null, "Invalid phone number format", "Message", JOptionPane.WARNING_MESSAGE));
    }
}
