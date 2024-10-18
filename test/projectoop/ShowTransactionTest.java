package projectoop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.JButton;
import javax.swing.JTable;

import static org.junit.Assert.*;

public class ShowTransactionTest {
    private ShowTransaction showTransaction;

    @Before
    public void setUp() {
        // Initialize the ShowTransaction object with a test user ID.
        showTransaction = new ShowTransaction(13); // Replace with a valid test user ID.
    }

    @After
    public void tearDown() {
        showTransaction.dispose(); // Close the JFrame after each test.
    }

    @Test
    public void testDisplayTr() {
        showTransaction.DisplayTr();

        // Assuming the table is filled with data, check if the table model is not empty
        JTable transactionTable = showTransaction.TransactionTable_Transaction;
        int rowCount = transactionTable.getModel().getRowCount();

        // Assert that row count is greater than 0 (modify this according to your test setup)
        assertTrue("Transaction table should not be empty", rowCount > 0);
    }

    @Test
    public void testBackButtonFunctionality() {
        JButton backButton = showTransaction.BackButton_Transaction;

        // Simulate a button click
        backButton.doClick(); // This will invoke the action associated with the button

        // You can check if the MainMenu is displayed by checking the instance count or state if possible
        // For this, you might need a more complex way to validate it, such as using mocks
    }

    @Test
    public void testShowHistoryButtonFunctionality() {
        JButton showHistoryButton = showTransaction.ShowHistoryButton_History;

        // Simulate a button click
        showHistoryButton.doClick(); // This will invoke the action associated with the button

        // You can check if the transaction list was updated accordingly
        // For more precise tests, consider mocking the database connection or using a test database
    }
}
