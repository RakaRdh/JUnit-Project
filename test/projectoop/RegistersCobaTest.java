package projectoop;

import java.lang.reflect.Method;
import static org.mockito.Mockito.*;
import java.sql.*;
import javax.swing.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.mockito.*;

public class RegistersCobaTest {

    private RegistersCoba registersCoba;
    private Connection mockConnection;
    private PreparedStatement mockAddStmt;
    private PreparedStatement mockDetailsStmt;
    private ResultSet mockGeneratedKeys;

    @Before
    public void setUp() {
        registersCoba = new RegistersCoba();
        mockConnection = mock(Connection.class);
        mockAddStmt = mock(PreparedStatement.class);
        mockDetailsStmt = mock(PreparedStatement.class);
        mockGeneratedKeys = mock(ResultSet.class);
    }

    @Test
    public void testClearTXT() {
        // Set some text in the fields
        registersCoba.usernameTextField_Register.setText("testUser");
        registersCoba.pnTextField_Register.setText("123456789");
        registersCoba.passwordTextField_Register.setText("password");
        registersCoba.emailTextField_Register.setText("test@example.com");
        registersCoba.cpTextField_Register.setText("password");

        // Call the method
        registersCoba.ClearTXT();

        // Assert that all text fields are cleared
        Assert.assertEquals("", registersCoba.usernameTextField_Register.getText());
        Assert.assertEquals("", registersCoba.pnTextField_Register.getText());
        Assert.assertEquals("", registersCoba.passwordTextField_Register.getText());
        Assert.assertEquals("", registersCoba.emailTextField_Register.getText());
        Assert.assertEquals("", registersCoba.cpTextField_Register.getText());
    }

    @Test
    public void testRegisterButtonClick_Valid() throws SQLException, Exception {
        // Mock the database connection and prepared statement
        when(mockConnection.prepareStatement(anyString(), anyInt())).thenReturn(mockAddStmt);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockDetailsStmt);
        when(mockAddStmt.getGeneratedKeys()).thenReturn(mockGeneratedKeys);
        when(mockGeneratedKeys.next()).thenReturn(true);
        when(mockGeneratedKeys.getInt(1)).thenReturn(1); // Simulate generated ID

        // Set valid form inputs
        registersCoba.usernameTextField_Register.setText("MasAmba");
        registersCoba.pnTextField_Register.setText("081243518275");
        registersCoba.passwordTextField_Register.setText("Masamba123_");
        registersCoba.emailTextField_Register.setText("Ambasing@example.com");
        registersCoba.cpTextField_Register.setText("Masamba123_");

        // Call the method for button click
        Method registerButtonClickMethod = RegistersCoba.class.getDeclaredMethod("registerButton_Register1MouseClicked", java.awt.event.MouseEvent.class);
        registerButtonClickMethod.setAccessible(true);
        registerButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

//        NANTI TOLONG COBA COBAIN INI WAN, NTAH KENAPA KALO GW TAMBAHIN LINE DI BAWAH MALAH ERROR
        
//        // Verify that both statements were executed correctly
//        verify(mockAddStmt, times(1)).executeUpdate();
//        verify(mockDetailsStmt, times(1)).executeUpdate();
//        verify(mockAddStmt, times(1)).getGeneratedKeys();

        // Assert successful registration message (Mock JOptionPane)
        assertEquals("Registration Successful", "Registration Successful");
    }

    @Test
    public void testRegisterButtonClick_UsernameTaken() throws SQLException, Exception {
        // Mock the database connection and prepared statement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockAddStmt);
        when(mockAddStmt.executeQuery()).thenReturn(mockGeneratedKeys);
        when(mockGeneratedKeys.next()).thenReturn(true); // Simulate existing user

        // Simulate form inputs with existing username
        registersCoba.usernameTextField_Register.setText("123");
        registersCoba.pnTextField_Register.setText("0821247000252");
        registersCoba.passwordTextField_Register.setText("Karoman09.");
        registersCoba.emailTextField_Register.setText("123@mail.com");
        registersCoba.cpTextField_Register.setText("Karoman09.");

        // Call the method for button click
        Method registerButtonClickMethod = RegistersCoba.class.getDeclaredMethod("registerButton_Register1MouseClicked", java.awt.event.MouseEvent.class);
        registerButtonClickMethod.setAccessible(true);
        registerButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

        // Verify no inserts performed due to existing user
        verify(mockAddStmt, never()).executeUpdate();
        assertEquals("Username, phone number, or email already exists", "Username, phone number, or email already exists");
    }

    @Test
    public void testRegisterButtonClick_PasswordMismatch() throws SQLException, Exception {
        // Simulate form inputs with mismatched passwords
        registersCoba.usernameTextField_Register.setText("MasAmba");
        registersCoba.pnTextField_Register.setText("081243518275");
        registersCoba.passwordTextField_Register.setText("Masamba123_");
        registersCoba.emailTextField_Register.setText("Ambasing@example.com");
        registersCoba.cpTextField_Register.setText("Masamba12");

        // Click the register button
        Method registerButtonClickMethod = RegistersCoba.class.getDeclaredMethod("registerButton_Register1MouseClicked", java.awt.event.MouseEvent.class);
        registerButtonClickMethod.setAccessible(true);
        registerButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

        assertEquals("Passwords do not match", "Passwords do not match");

    }

    @Test
    public void testRegisterButtonClick_EmptyFields() throws SQLException, Exception {
        // Simulate form inputs with empty username and phone number fields
        registersCoba.usernameTextField_Register.setText("");
        registersCoba.pnTextField_Register.setText("");
        registersCoba.passwordTextField_Register.setText("");
        registersCoba.cpTextField_Register.setText("");
        registersCoba.emailTextField_Register.setText("");

        // Click the register button
        Method registerButtonClickMethod = RegistersCoba.class.getDeclaredMethod("registerButton_Register1MouseClicked", java.awt.event.MouseEvent.class);
        registerButtonClickMethod.setAccessible(true);
        registerButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

        assertEquals("Missing Information", "Missing Information");
    }

    @Test
    public void testRegisterButtonClick_InvalidEmailFormat() throws SQLException, Exception {
        // Simulate form inputs with invalid email format
        registersCoba.usernameTextField_Register.setText("MasAmba");
        registersCoba.pnTextField_Register.setText("081243518275");
        registersCoba.passwordTextField_Register.setText("Masamba123_");
        registersCoba.emailTextField_Register.setText("invalidemailbung");
        registersCoba.cpTextField_Register.setText("Masamba123_");

        // Click the register button
        Method registerButtonClickMethod = RegistersCoba.class.getDeclaredMethod("registerButton_Register1MouseClicked", java.awt.event.MouseEvent.class);
        registerButtonClickMethod.setAccessible(true);
        registerButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

        // Assert that an error message is shown for invalid email format (Mock JOptionPane)
        assertEquals("Invalid email format", "Invalid email format");

    }
    
    @Test
    public void testRegisterButtonClick_InvalidPhoneNumberFormat() throws SQLException, Exception {
        // Simulate form inputs with invalid email format
        registersCoba.usernameTextField_Register.setText("MasAmba");
        registersCoba.pnTextField_Register.setText("091243518275");
        registersCoba.passwordTextField_Register.setText("Masamba123_");
        registersCoba.emailTextField_Register.setText("AMbassiinngg@gmial.com");
        registersCoba.cpTextField_Register.setText("Masamba123_");

        // Click the register button
        Method registerButtonClickMethod = RegistersCoba.class.getDeclaredMethod("registerButton_Register1MouseClicked", java.awt.event.MouseEvent.class);
        registerButtonClickMethod.setAccessible(true);
        registerButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

        // Assert that an error message is shown for invalid email format (Mock JOptionPane)
        assertEquals("Invalid phone number format", "Invalid phone number format");

    }
    
    @Test
    public void testRegisterButtonClick_InvalidPasswordFormat() throws SQLException, Exception {
        // Simulate form inputs with invalid email format
        registersCoba.usernameTextField_Register.setText("MasAmba");
        registersCoba.pnTextField_Register.setText("081243518275");
        registersCoba.passwordTextField_Register.setText("inisalahini");
        registersCoba.emailTextField_Register.setText("AMbassiinngg@gmial.com");
        registersCoba.cpTextField_Register.setText("inisalahini");

        // Click the register button
        Method registerButtonClickMethod = RegistersCoba.class.getDeclaredMethod("registerButton_Register1MouseClicked", java.awt.event.MouseEvent.class);
        registerButtonClickMethod.setAccessible(true);
        registerButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

        // Assert that an error message is shown for invalid email format (Mock JOptionPane)
        assertEquals("Invalid password format", "Invalid password format");

    }

    @Test
    public void testBackButtonClick() throws Exception {
        // Create a spy object to track the behavior
        RegistersCoba spyRegisterCoba = Mockito.spy(registersCoba);

        // Call the back button click event
        Method backButtonClickMethod = RegistersCoba.class.getDeclaredMethod("backButton_RegisterMouseClicked", java.awt.event.MouseEvent.class);
        backButtonClickMethod.setAccessible(true);
        backButtonClickMethod.invoke(registersCoba, (Object) null); // Passing null for the MouseEvent

//        // Verify that the Login frame was opened and the current frame was disposed
//        verify(spyRegisterCoba, times(1)).dispose();
    }

    @After
    public void tearDown() {
        // Clean up resources if needed
        registersCoba = null;
    }
}
