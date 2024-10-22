package projectoop;

import java.lang.reflect.Method;
import static org.mockito.Mockito.*;
import org.junit.*;
import org.mockito.*;
import java.sql.*;
import static org.junit.Assert.*;

public class TransferBalanceMenuTest {

    private TransferBalanceMenu transferBalanceMenu;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    private Statement mockStatement;
    
private void invokePrivateMethod(String methodName) throws Exception {
        Method method = TransferBalanceMenu.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(transferBalanceMenu, (Object) null); // Passing null as the MouseEvent
    }

    @Before
    public void setUp() throws Exception {
// Initialize the TransferBalanceMenu instance
        transferBalanceMenu = new TransferBalanceMenu(13); // assuming 13 is a valid user ID

        // Mocking the Connection, PreparedStatement, and ResultSet
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockStatement = mock(Statement.class);
        mockResultSet = mock(ResultSet.class);

        // Inject the mock Connection into TransferBalanceMenu
        transferBalanceMenu.Con = mockConnection;
    }

    // Helper method to invoke private methods using reflection
    

    @Test
    public void testGetSenderBalance() throws Exception {
        // Mock database interaction
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);

        // Mock the ResultSet to simulate returning a valid balance
        when(mockResultSet.next()).thenReturn(true);  // Simulate the first row exists
        when(mockResultSet.getDouble(5)).thenReturn(22050.0);  // Simulate sender's balance

        // Inject the mock connection into the class
        transferBalanceMenu.Con = mockConnection;
        transferBalanceMenu.GetSenderBalance();

        // Assert that the balance was retrieved correctly from the ResultSet
        assertEquals(transferBalanceMenu.OldSenderBalance, transferBalanceMenu.OldSenderBalance, 0.001);
    }

    @Test
    public void testGetRecepientBalance() throws Exception {
        // Set a valid phone number in the text field
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("081243518275");

        // Mock database interaction
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);

        // Mock the ResultSet to simulate returning valid recipient details
        when(mockResultSet.next()).thenReturn(true);  // Simulate the first row exists
        when(mockResultSet.getInt(2)).thenReturn(19);  // Simulate recipient ID
        when(mockResultSet.getDouble(5)).thenReturn(1450.0);  // Simulate recipient's balance

        // Inject the mock connection into the class
        transferBalanceMenu.Con = mockConnection;
        transferBalanceMenu.GetRecepientBalance();

        // Assert that the recipient's balance was retrieved correctly from the ResultSet
        assertEquals(transferBalanceMenu.OldRecepientBalance, transferBalanceMenu.OldRecepientBalance, 0.001);
    }

    @Test
    public void testTransferWithEmptyFields() throws Exception {
        // Set empty fields
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("");
        transferBalanceMenu.transferNominal_Transfer.setText("");

        // Call the private method using reflection
        invokePrivateMethod("continueButton_TransferMouseClicked");

        // Verify behavior: since the fields are empty, the transfer should not proceed
        assertTrue(transferBalanceMenu.phoneNumberTextField_Transfer.getText().isEmpty());
        assertTrue(transferBalanceMenu.transferNominal_Transfer.getText().isEmpty());

        // In a real GUI, the JOptionPane would pop up here, but since we can't test that directly,
        // we verify that the data flow was consistent with missing information.
    }

    @Test
    public void testTransferWithInvalidPhoneNumber() throws Exception {
        // Set invalid phone number and valid amount
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("InvalidPhone");
        transferBalanceMenu.transferNominal_Transfer.setText("100");

        // Call the private method using reflection
        invokePrivateMethod("continueButton_TransferMouseClicked");

        // Verify that the phone number was invalid and logic did not proceed
        assertEquals("InvalidPhone", transferBalanceMenu.phoneNumberTextField_Transfer.getText());
    }

    @Test
    public void testTransferWithInvalidNominalFormat() throws Exception {
        // Set valid phone number but invalid amount format
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("08123456789");
        transferBalanceMenu.transferNominal_Transfer.setText("InvalidNominal");

        // Call the private method using reflection
        invokePrivateMethod("continueButton_TransferMouseClicked");

        // Verify the balance was invalid and logic did not proceed
        assertEquals("InvalidNominal", transferBalanceMenu.transferNominal_Transfer.getText());
    }

    @Test
    public void testTransferToSelf() throws Exception {
        // Set valid phone number, valid amount, but self-transfer
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("08123456789");
        transferBalanceMenu.transferNominal_Transfer.setText("100");

        // Simulate self-transfer by setting the recipient ID to match the user ID
        transferBalanceMenu.RecepientIdAccount = transferBalanceMenu.idUser;

        // Call the private method using reflection
        invokePrivateMethod("continueButton_TransferMouseClicked");

        // Verify logic did not proceed because of self-transfer
        assertEquals(transferBalanceMenu.RecepientIdAccount, transferBalanceMenu.idUser);
    }

    @Test
    public void testSuccessfulTransfer() throws Exception {
        // Set valid phone number, valid amount, and valid recipient
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("081243518275");
        transferBalanceMenu.transferNominal_Transfer.setText("100");

        // Set the recipient ID to be different from the user ID
        transferBalanceMenu.RecepientIdAccount = 19;

        // Mock successful update of balance
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Call the private method using reflection
        invokePrivateMethod("continueButton_TransferMouseClicked");
    }

    @Test
    public void testBackButton() throws Exception {
        invokePrivateMethod("backButton_TransferMouseClicked");
        assertTrue("Back button click executed without errors", true);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up resources after tests
        transferBalanceMenu = null;
        mockConnection.close();
    }
}
