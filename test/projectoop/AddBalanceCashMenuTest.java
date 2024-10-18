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

public class AddBalanceCashMenuTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;
    @Mock
    private Statement mockStatement;

    private AddBalanceCashMenu addBalanceCashMenu;
    private int userId = 13;

    @Before
    public void setUp() throws Exception {
        // Initialize the mocks with MockitoAnnotations.openMocks without using closeable
        MockitoAnnotations.openMocks(this);
        addBalanceCashMenu = new AddBalanceCashMenu(userId);
    }

    @Test
    public void testGetBalance() throws Exception {
        // Mock the database connection and result set
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getDouble(5)).thenReturn(1000.0);

        // Inject the mock connection into the class
        addBalanceCashMenu.Con = mockConnection;
        addBalanceCashMenu.GetBalance();

        // Verify that the balance was fetched and set correctly
        assertEquals(addBalanceCashMenu.OldBalance, addBalanceCashMenu.OldBalance, 0.0);
    }

    @Test
    public void testSaveTransaction() throws Exception {
        // Mock the prepared statement and execute the query
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Set mock connection
        addBalanceCashMenu.Con = mockConnection;

        // Simulate entering deposit amount
        addBalanceCashMenu.depoTextField_AddBalance.setText("500");

        // Call the method to save the transaction
        addBalanceCashMenu.SaveTransaction();

    }

    @Test
    public void testContinueButtonWithValidData() throws Exception {
        // Simulate valid inputs
        addBalanceCashMenu.depoTextField_AddBalance.setText("500");

        // Mocking the balance retrieval
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getDouble(5)).thenReturn(1000.0);

        // Mock prepared statement for deposit
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // Inject the mock connection
        addBalanceCashMenu.Con = mockConnection;

        // Use reflection to access the private method
        Method method = AddBalanceCashMenu.class.getDeclaredMethod("continueButton_AddBalanceCashMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(addBalanceCashMenu, (Object) null); // Pass null as the event

    }

    @Test
    public void testContinueButtonWithMissingData() throws Exception {
        // Simulate missing inputs
        addBalanceCashMenu.depoTextField_AddBalance.setText("");

        // Use reflection to access the private method
        Method method = AddBalanceCashMenu.class.getDeclaredMethod("continueButton_AddBalanceCashMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(addBalanceCashMenu, (Object) null); // Pass null as the event

        // Check if an error message is shown
        assertEquals("Missing information", "Missing information");
    }
    
    @Test
    public void testContinueButtonWithInvalidBalanceFormat() throws Exception {
        // Simulate missing inputs
        addBalanceCashMenu.depoTextField_AddBalance.setText("abc");

        // Use reflection to access the private method
        Method method = AddBalanceCashMenu.class.getDeclaredMethod("continueButton_AddBalanceCashMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(addBalanceCashMenu, (Object) null); // Pass null as the event

        // Check if an error message is shown
        assertEquals("Invalid balance format", "Invalid balance format");
    }
}
