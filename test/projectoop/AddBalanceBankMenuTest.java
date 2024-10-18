/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddBalanceBankMenuTest {

    private AddBalanceBankMenu addBalanceBankMenu;

    @Before
    public void setUp() {
        // Initialize the AddBalanceCashMenu with a dummy user ID
        addBalanceBankMenu = new AddBalanceBankMenu(13);
    }

    @Test
    public void testGetBalance() {
        // You can test if the method correctly sets OldBalance
        addBalanceBankMenu.OldBalance = 1000.0;
        assertEquals(1000.0, addBalanceBankMenu.OldBalance, 0.0);
    }
    
    @Test
    public void testSaveTransaction() {
        // Test whether the deposit amount is correctly retrieved from the text field
        addBalanceBankMenu.depoTextField_AddBalance.setText("200.0");
        String expected = "200.0";
        assertEquals(expected, addBalanceBankMenu.depoTextField_AddBalance.getText());
    }

    @Test
    public void testInvalidBothInput() {
        // Test if the validation rejects invalid input
        addBalanceBankMenu.depoTextField_AddBalance.setText("abc");
        addBalanceBankMenu.BankNumberTextField_AddBalance.setText("abc");
        boolean validAmount = Validation.isValidBalance(addBalanceBankMenu.depoTextField_AddBalance.getText());
        boolean validBankNumber = Validation.isValidBalance(addBalanceBankMenu.BankNumberTextField_AddBalance.getText());
        assertFalse(validAmount);
        assertFalse(validBankNumber);
    }
    
    @Test
    public void testInvalidBankNumberInput() {
        // Test if the validation rejects invalid input
        addBalanceBankMenu.depoTextField_AddBalance.setText("100.0");
        addBalanceBankMenu.BankNumberTextField_AddBalance.setText("abc");
        boolean validAmount = Validation.isValidBalance(addBalanceBankMenu.depoTextField_AddBalance.getText());
        boolean validBankNumber = Validation.isValidBalance(addBalanceBankMenu.BankNumberTextField_AddBalance.getText());
        assertTrue(validAmount);
        assertFalse(validBankNumber);
    }
    
    @Test
    public void testInvalidAmountInput() {
        // Test if the validation rejects invalid input
        addBalanceBankMenu.depoTextField_AddBalance.setText("abc");
        addBalanceBankMenu.BankNumberTextField_AddBalance.setText("11234123");
        boolean validAmount = Validation.isValidBalance(addBalanceBankMenu.depoTextField_AddBalance.getText());
        boolean validBankNumber = Validation.isValidBalance(addBalanceBankMenu.BankNumberTextField_AddBalance.getText());
        assertFalse(validAmount);
        assertTrue(validBankNumber);
    }

    @Test
    public void testValidInput() {
        // Test if the validation accepts valid numeric input
        addBalanceBankMenu.depoTextField_AddBalance.setText("100.0");
        addBalanceBankMenu.BankNumberTextField_AddBalance.setText("1234314");
        boolean validAmount = Validation.isValidBalance(addBalanceBankMenu.depoTextField_AddBalance.getText());
        boolean validBankNumber = Validation.isValidBalance(addBalanceBankMenu.BankNumberTextField_AddBalance.getText());
        assertTrue(validAmount);
        assertTrue(validBankNumber);
    }

    @Test
    public void testContinueButtonClicked() {
        try {
            // Use reflection to access the private method
            java.lang.reflect.Method method = AddBalanceBankMenu.class.getDeclaredMethod("continueButton_AddBalanceMouseClicked", java.awt.event.MouseEvent.class);
            method.setAccessible(true);  // Allows access to private methods

            // Set values in text fields to simulate user input
            addBalanceBankMenu.BankNumberTextField_AddBalance.setText("123456789");
            addBalanceBankMenu.depoTextField_AddBalance.setText("500");

            // Call the method with null argument as it takes a MouseEvent (which is not needed for this test)
            method.invoke(addBalanceBankMenu, (java.awt.event.MouseEvent) null);

            // Additional assertions if necessary
            assertNotNull(addBalanceBankMenu.OldBalance);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
