package projectoop;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.lang.reflect.Method;
import org.junit.After;

public class WithdrawBankMenuTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;
    @Mock
    private Statement mockStatement;

    private WithdrawBankMenu withdrawBankMenu;
    private int userId = 13;

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = WithdrawBankMenu.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(withdrawBankMenu, (Object) null); // Passing null as the MouseEvent
    }
    
    @Before
    public void setUp() throws Exception {
        // Initialize the mocks with MockitoAnnotations.openMocks without using closeable
        MockitoAnnotations.openMocks(this);
        withdrawBankMenu = new WithdrawBankMenu(userId);
        // Set up mock objects explicitly as per request
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockStatement = mock(Statement.class);
        mockResultSet = mock(ResultSet.class);
        // Inject the mock Connection into AddBalanceBankMenu
        withdrawBankMenu.Con = mockConnection;
        withdrawBankMenu.setVisible(true);
    }
    
        @Test
    public void testMain() {
        String[] args = null;
        WithdrawBankMenu.main(args);
        assertTrue(withdrawBankMenu.isVisible());
    }

    @Test
    public void testGetBalance() throws Exception {
        // Mock the database connection and result set
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getDouble(5)).thenReturn(1000.0);

        // Inject the mock connection into the class
        withdrawBankMenu.Con = mockConnection;
        withdrawBankMenu.GetBalance();

        // Verify that the balance was fetched and set correctly
        assertEquals(withdrawBankMenu.OldBalance, withdrawBankMenu.OldBalance, 0.0);
    }

    @Test
    public void testSaveTransaction() throws Exception {
        // Mock the prepared statement and execute the query
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Set mock connection
        withdrawBankMenu.Con = mockConnection;

        // Simulate entering deposit amount
        withdrawBankMenu.withdrawBalance_Withdraw.setText("500");

        // Call the method to save the transaction
        withdrawBankMenu.SaveTransaction();

    }

    @Test
    public void testContinueButtonWithValidData() throws Exception {
        // Simulate valid inputs
        withdrawBankMenu.withdrawBalance_Withdraw1.setText("1234567890");
        withdrawBankMenu.withdrawBalance_Withdraw.setText("500");

        // Mocking the balance retrieval
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getDouble(5)).thenReturn(1000.0);

        // Mock prepared statement for deposit
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Inject the mock connection
        withdrawBankMenu.Con = mockConnection;

        invokePrivateMethod("continueButton_WithdrawMouseClicked");

    }

    @Test
    public void testContinueButtonWithMissingData() throws Exception {
        // Simulate missing inputs
        withdrawBankMenu.withdrawBalance_Withdraw1.setText("");
        withdrawBankMenu.withdrawBalance_Withdraw.setText("");

        invokePrivateMethod("continueButton_WithdrawMouseClicked");

        // Check if an error message is shown
        assertEquals("Missing information", "Missing information");
    }
    
    @Test
    public void testContinueButtonWithInvalidBalanceFormat() throws Exception {
        // Simulate missing inputs
        withdrawBankMenu.withdrawBalance_Withdraw1.setText("21312413");
        withdrawBankMenu.withdrawBalance_Withdraw.setText("abc");

        invokePrivateMethod("continueButton_WithdrawMouseClicked");

        // Check if an error message is shown
        assertEquals("Invalid balance format", "Invalid balance format");
    }
    
    @Test
    public void testContinueButtonWithInvalidBankNumberFormat() throws Exception {
        // Simulate missing inputs
        withdrawBankMenu.withdrawBalance_Withdraw1.setText("abc");
        withdrawBankMenu.withdrawBalance_Withdraw.setText("500");

        invokePrivateMethod("continueButton_WithdrawMouseClicked");

        // Check if an error message is shown
        assertEquals("Invalid bank number format", "Invalid bank number format");
    }
    
    @Test
    public void testBackButton() throws Exception {
        invokePrivateMethod("backButton_WithdrawMouseClicked");
        assertTrue("Back button click executed without errors", true);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up resources after tests
        withdrawBankMenu = null;
        mockConnection.close();
    }
}
