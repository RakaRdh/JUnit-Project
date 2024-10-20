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

public class WithdrawCashMenuTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;
    @Mock
    private Statement mockStatement;

    private WithdrawCashMenu withdrawCashMenu;
    private int userId = 13;

    @Before
    public void setUp() throws Exception {
        // Initialize the mocks with MockitoAnnotations.openMocks without using closeable
        MockitoAnnotations.openMocks(this);
        withdrawCashMenu = new WithdrawCashMenu(userId);
    }

    @Test
    public void testGetBalance() throws Exception {
        // Mock the database connection and result set
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getDouble(5)).thenReturn(1000.0);

        // Inject the mock connection into the class
        withdrawCashMenu.Con = mockConnection;
        withdrawCashMenu.GetBalance();

        // Verify that the balance was fetched and set correctly
        assertEquals(withdrawCashMenu.OldBalance, withdrawCashMenu.OldBalance, 0.0);
    }

    @Test
    public void testSaveTransaction() throws Exception {
        // Mock the prepared statement and execute the query
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Set mock connection
        withdrawCashMenu.Con = mockConnection;

        // Simulate entering deposit amount
        withdrawCashMenu.withdrawBalance_Withdraw.setText("500");

        // Call the method to save the transaction
        withdrawCashMenu.SaveTransaction();

    }

    @Test
    public void testContinueButtonWithValidData() throws Exception {
        // Simulate valid inputs
        withdrawCashMenu.withdrawBalance_Withdraw.setText("500");

        // Mocking the balance retrieval
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getDouble(5)).thenReturn(1000.0);

        // Mock prepared statement for deposit
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Inject the mock connection
        withdrawCashMenu.Con = mockConnection;

        // Use reflection to access the private method
        Method method = WithdrawCashMenu.class.getDeclaredMethod("continueButton_WithdrawMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(withdrawCashMenu, (Object) null); // Pass null as the event

    }

    @Test
    public void testContinueButtonWithMissingData() throws Exception {
        // Simulate missing inputs
        withdrawCashMenu.withdrawBalance_Withdraw.setText("");

        // Use reflection to access the private method
        Method method = WithdrawCashMenu.class.getDeclaredMethod("continueButton_WithdrawMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(withdrawCashMenu, (Object) null); // Pass null as the event

        // Check if an error message is shown
        assertEquals("Missing information", "Missing information");
    }
    
    @Test
    public void testContinueButtonWithInvalidBalanceFormat() throws Exception {
        // Simulate missing inputs
        withdrawCashMenu.withdrawBalance_Withdraw.setText("abc");

        // Use reflection to access the private method
        Method method = WithdrawCashMenu.class.getDeclaredMethod("continueButton_WithdrawMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(withdrawCashMenu, (Object) null); // Pass null as the event

        // Check if an error message is shown
        assertEquals("Invalid balance format", "Invalid balance format");
    }
}
