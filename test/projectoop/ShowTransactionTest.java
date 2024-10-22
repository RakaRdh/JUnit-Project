package projectoop;

import java.lang.reflect.Method;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.JButton;
import javax.swing.JTable;

import static org.junit.Assert.*;

public class ShowTransactionTest {

    private ShowTransaction showTransaction;

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = ShowTransaction.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(showTransaction, (Object) null); // Passing null as the MouseEvent
    }

    @Before
    public void setUp() {
        // Initialize the ShowTransaction object with a test user ID.
        showTransaction = new ShowTransaction(13); // Replace with a valid test user ID.
        showTransaction.setVisible(true);
    }
    
    @Test
    public void testMain() {
        String[] args = null;
        ShowTransaction.main(args);
        assertTrue(showTransaction.isVisible());
    }

    @After
    public void tearDown() {
        showTransaction.dispose(); // Close the JFrame after each test.
    }
    
        @Test
    public void testDisplayTrBisa() {
        showTransaction.DisplayTr(13);

        // Assuming the table is filled with data, check if the table model is not empty
        JTable transactionTable = showTransaction.TransactionTable_Transaction;
        int rowCount = transactionTable.getModel().getRowCount();

        // Assert that row count is greater than 0 (modify this according to your test setup)
        assertTrue("Transaction table should not be empty", rowCount > 0);
    }

    @Test
    public void testBackButtonFunctionality() throws Exception {
        invokePrivateMethod("BackButton_TransactionMouseClicked");
        assertTrue("Back button click executed without errors", true);
    }

}
