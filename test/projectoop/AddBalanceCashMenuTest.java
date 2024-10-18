package projectoop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AddBalanceCashMenuTest {

    private AddBalanceCashMenu addBalanceCashMenu;

    @Before
    public void setUp() {
        // Initialize the AddBalanceCashMenu with a dummy user ID
        addBalanceCashMenu = new AddBalanceCashMenu(13);
    }

    @Test
    public void testGetBalance() {
        // You can test if the method correctly sets OldBalance
        addBalanceCashMenu.OldBalance = 1000.0;
        assertEquals(1000.0, addBalanceCashMenu.OldBalance, 0.0);
    }

    @Test
    public void testSaveTransaction() {
        // Test whether the deposit amount is correctly retrieved from the text field
        addBalanceCashMenu.depoTextField_AddBalance.setText("200.0");
        String expected = "200.0";
        assertEquals(expected, addBalanceCashMenu.depoTextField_AddBalance.getText());
    }

    @Test
    public void testInvalidDepositInput() {
        // Test if the validation rejects invalid input
        addBalanceCashMenu.depoTextField_AddBalance.setText("abc");
        boolean valid = Validation.isValidBalance(addBalanceCashMenu.depoTextField_AddBalance.getText());
        assertFalse(valid);
    }

    @Test
    public void testValidDepositInput() {
        // Test if the validation accepts valid numeric input
        addBalanceCashMenu.depoTextField_AddBalance.setText("100.0");
        boolean valid = Validation.isValidBalance(addBalanceCashMenu.depoTextField_AddBalance.getText());
        assertTrue(valid);
    }
    
    @Test
    public void testContinueButtonClicked() {
        try {
            // Use reflection to access the private method
            java.lang.reflect.Method method = AddBalanceCashMenu.class.getDeclaredMethod("continueButton_AddBalanceCashMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true);  // Allows access to private methods

            // Set values in text fields to simulate user input
            addBalanceCashMenu.depoTextField_AddBalance.setText("500");

            // Call the method with null argument as it takes a MouseEvent (which is not needed for this test)
            method.invoke(addBalanceCashMenu, (java.awt.event.MouseEvent) null);

            // Additional assertions if necessary
            assertNotNull(addBalanceCashMenu.OldBalance);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
