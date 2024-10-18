package projectoop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;

public class TransferBalanceMenuTest {
    private TransferBalanceMenu transferBalanceMenu;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        // Initialize TransferBalanceMenu with a test user ID
        transferBalanceMenu = new TransferBalanceMenu(13); // assuming 1 is a valid user ID
        // Establish a connection to the test database
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb-test", "root", "");
    }

    @Test
    public void testGetSenderBalance() throws Exception {
        invokeMethod("GetSenderBalance");
        // Validate the sender's balance
        assertNotEquals("Sender balance should be greater than zero.", 0, transferBalanceMenu.OldSenderBalance);
    }

    @Test
    public void testGetRecepientBalance() throws Exception {
        // Set a valid phone number in the text field
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("1"); // replace with a valid phone number
        invokeMethod("GetRecepientBalance");
        // Validate the recipient's balance
        assertNotEquals("Recipient balance should be greater than zero.", 0, transferBalanceMenu.OldRecepientBalance);
    }

    @Test
    public void testSaveTransaction() throws Exception {
        // Setup test data
        transferBalanceMenu.idUser = 13; // assuming this is a valid sender ID
        transferBalanceMenu.RecepientIdAccount = 2; // assuming this is a valid recipient ID
        transferBalanceMenu.transferNominal_Transfer.setText("100"); // Test amount

        invokeMethod("SaveTransaction");

        // Verify the transaction has been saved correctly
        String query = "SELECT * FROM transaction WHERE id_account = ? ORDER BY id_transaction DESC LIMIT 1";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, transferBalanceMenu.idUser);
            ResultSet rs = stmt.executeQuery();
            assertTrue("Transaction should be saved in the database for the sender.", rs.next());
            assertEquals("Transaction type should be 'Transfer'.", "Transfer", rs.getString("transaction"));
            assertEquals("Transaction amount should be 100.", 100, rs.getDouble("amount"), 0.001);
        }
    }

    @Test
    public void testTransferBalance() throws Exception {
        // Assuming valid inputs for testing
        transferBalanceMenu.phoneNumberTextField_Transfer.setText("recipient_phone_number"); // replace with valid number
        transferBalanceMenu.transferNominal_Transfer.setText("50"); // Test amount

        // Store old balances
        double oldSenderBalance = transferBalanceMenu.OldSenderBalance;
        double oldRecepientBalance = transferBalanceMenu.OldRecepientBalance;

        // Call the transfer function
                // Use reflection to access the private method
        Method method = TransferBalanceMenu.class.getDeclaredMethod("continueButton_TransferMouseClicked", java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(transferBalanceMenu, (Object) null); // Pass null as the event

        // Verify balances after transfer
        assertEquals("Sender balance should be reduced by 50.", oldSenderBalance - 50, transferBalanceMenu.OldSenderBalance, 0.001);
        assertEquals("Recipient balance should be increased by 50.", oldRecepientBalance + 50, transferBalanceMenu.OldRecepientBalance, 0.001);
    }

    private void invokeMethod(String methodName, Object... args) throws Exception {
        // Get the method with the specified name and parameter types
        Method method = TransferBalanceMenu.class.getDeclaredMethod(methodName, getParameterTypes(args));
        method.setAccessible(true); // Allow access to private methods
        method.invoke(transferBalanceMenu, args); // Invoke the method
    }

    private Class<?>[] getParameterTypes(Object... args) {
        return java.util.Arrays.stream(args)
                .map(arg -> arg == null ? Object.class : arg.getClass())
                .toArray(Class<?>[]::new);
    }

    @After
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
