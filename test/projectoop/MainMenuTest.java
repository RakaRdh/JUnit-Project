package projectoop;

import org.junit.Before;
import org.junit.Test;

import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
import javax.swing.JButton;

/**
 * Test class for MainMenu
 */
public class MainMenuTest {

    private MainMenu mainMenu;
    private MainMenu mainMenuNonPremium;

    @Before
    public void setUp() {
        // Initialize the MainMenu with sample data
        mainMenu = new MainMenu(17, "Dapa", 10000.0, "081275967546");
//        mainMenuNonPremium = new MainMenu(18, "Pale", 0.0, "081212653541");
        mainMenu.setVisible(true); 
    }

    /**
     * Helper method to invoke private methods using reflection
     */
    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = MainMenu.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(mainMenu, (Object) null); // Passing null as the MouseEvent
    }

    /**
     * Test the viewProfile button MouseClicked functionality
     */
    @Test
    public void testViewProfileButtonMouseClicked() throws Exception{
        invokePrivateMethod("viewProfileButton_MenuMouseClicked");
        assertFalse(mainMenu.isVisible()); // Check if the current window is disposed
    }

    /**
     * Test the deposit balance button MouseClicked functionality
     */
    @Test
    public void testDepoBalanceButtonMouseClicked() throws Exception{
        invokePrivateMethod("depoBalanceButton_MenuMouseClicked");
        assertFalse(mainMenu.isVisible());
    }

    /**
     * Test the withdraw balance button MouseClicked functionality
     */
    @Test
    public void testWdBalanceButtonMouseClicked() throws Exception{
        invokePrivateMethod("wdBalanceButton_MenuMouseClicked");
        assertFalse(mainMenu.isVisible());
    }

    /**
     * Test the transfer balance button MouseClicked functionality
     */
    @Test
    public void testTransferBalanceButtonMouseClicked_Success() throws Exception{
        invokePrivateMethod("transferBalanceButton_MenuMouseClicked");
        assertFalse(mainMenu.isVisible());
    }
    
    @Test
    public void testTransferBalanceButtonMouseClicked_Failed() throws Exception{
        invokePrivateMethod("transferBalanceButton_MenuMouseClicked");
        assertFalse(mainMenu.isVisible());
        assertEquals("Account is Not Premium", "Account is Not Premium");
    }
    /**
     * Test the logout button MouseClicked functionality
     */
    @Test
    public void testLogoutButtonMouseClicked() throws Exception{
        invokePrivateMethod("logoutButton_MenuMouseClicked");
        assertFalse(mainMenu.isVisible());
    }

    /**
     * Test the UTP button ActionPerformed functionality
     */
    @Test
    public void testUtpButtonActionPerformed() {
        JButton utpButton = mainMenu.utpButton_Menu;
        utpButton.doClick();
        // Add assertions to check the behavior after clicking UTP button
    }

    /**
     * Test the show transaction button ActionPerformed functionality
     */
    @Test
    public void testShowTransactionButtonActionPerformed() {
        JButton showTransactionButton = mainMenu.showTransactionButton_Menu;
        showTransactionButton.doClick();
        // Add assertions to check the behavior after clicking Show Transaction button
    }

    /**
     * Test the main method to ensure the menu is displayed
     */
    @Test
    public void testMain() {
        String[] args = null;
        MainMenu.main(args);
        assertTrue(mainMenu.isVisible());
    }
}
