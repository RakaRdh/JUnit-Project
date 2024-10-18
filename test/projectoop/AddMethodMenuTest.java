package projectoop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;

public class AddMethodMenuTest {

    private AddMethodMenu addMethodMenu;

    @Before
    public void setUp() {
        // Initialize the WDMethodMenu with a dummy user ID (13)
        addMethodMenu = new AddMethodMenu(13);
    }

    /**
     * Test that the initial user ID is set correctly
     */
    @Test
    public void testInitialUserId() {
        assertEquals(13, addMethodMenu.idUser);
    }

    /**
     * Test the behavior when the Bank button is clicked
     */
    @Test
    public void testBankMenuButtonAction() {
        JButton bankButton = addMethodMenu.Bank_MenuDP;
        
        // Simulate a button click for the Bank button
        bankButton.doClick();

        // After clicking, the current window should be disposed, 
        // and the WithdrawBankMenu should be displayed
        assertFalse(addMethodMenu.isVisible());
        // Further assertions can be made to confirm the new menu is displayed correctly
    }

    /**
     * Test the behavior when the Cash button is clicked
     */
    @Test
    public void testCashMenuButtonAction() {
        JButton cashButton = addMethodMenu.Cash_MenuDP;
        
        // Simulate a button click for the Cash button
        cashButton.doClick();

        // After clicking, the current window should be disposed, 
        // and the WithdrawCashMenu should be displayed
        assertFalse(addMethodMenu.isVisible());
        // Additional assertions can be made to check the new menu's visibility
    }

    /**
     * Test the behavior when the Back button is clicked
     */
    @Test
    public void testBackButtonAction() {
        JButton backButton = addMethodMenu.BackButton_MenuDPWD;
        
        // Simulate a button click for the Back button
        backButton.doClick();

        // After clicking, the current window should be disposed, 
        // and the MainMenu should be displayed
        assertFalse(addMethodMenu.isVisible());
        // Additional checks can be added to ensure the MainMenu is displayed
    }

    /**
     * Test valid account retrieval logic
     */
    @Test
    public void testValidAccountRetrieval() {
        // Simulate a valid account retrieval process
        // You would implement the logic for retrieving account information here.
        
        // For example, if you have a method to get account info, assert the expected results
        // Account account = wdMethodMenu.getAccountInfo(wdMethodMenu.idUser);
        // assertNotNull(account);
        // assertEquals(wdMethodMenu.idUser, account.getId());
    }

    /**
     * Test behavior on invalid account retrieval
     */
    @Test
    public void testInvalidAccountRetrieval() {
        // Simulate an invalid account retrieval process
        // Modify the idUser or setup your database to ensure no results are returned.
        
        // Assume we have a method that checks account validity and sets an error message
        // wdMethodMenu.idUser = -1; // Set to an invalid user ID
        // wdMethodMenu.checkAccountValidity();
        
        // Assert the expected error message is shown
        // assertEquals("Wrong Username or Password", wdMethodMenu.errorMessage);
    }
}
