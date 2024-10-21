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
    private MainMenu mainMenuNonPremi;

    @Before
    public void setUp() {
        // Initialize the MainMenu with sample data
        mainMenu = new MainMenu(15, "Ojan", 0, "083288888888");
        mainMenu.setVisible(true); 
    }

    /**
     * Helper method to invoke private methods using reflection
     */
    private void invokePrivateMethod(String methodName, Class<?>[] paramTypes, Object... params) {
        try {
            Method method = MainMenu.class.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            method.invoke(mainMenu, params);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to invoke method: " + methodName);
        }
    }

    /**
     * Test the viewProfile button MouseClicked functionality
     */
    @Test
    public void testViewProfileButtonMouseClicked() {
        invokePrivateMethod("viewProfileButton_MenuMouseClicked", new Class[]{MouseEvent.class}, (MouseEvent) null);
        assertFalse(mainMenu.isVisible()); // Check if the current window is disposed
    }

    /**
     * Test the deposit balance button MouseClicked functionality
     */
    @Test
    public void testDepoBalanceButtonMouseClicked() {
        invokePrivateMethod("depoBalanceButton_MenuMouseClicked", new Class[]{MouseEvent.class}, (MouseEvent) null);
        assertFalse(mainMenu.isVisible());
    }

    /**
     * Test the withdraw balance button MouseClicked functionality
     */
    @Test
    public void testWdBalanceButtonMouseClicked() {
        invokePrivateMethod("wdBalanceButton_MenuMouseClicked", new Class[]{MouseEvent.class}, (MouseEvent) null);
        assertFalse(mainMenu.isVisible());
    }

    /**
     * Test the transfer balance button MouseClicked functionality
     */
    @Test
    public void testTransferBalanceButtonMouseClicked() {
        invokePrivateMethod("transferBalanceButton_MenuMouseClicked", new Class[]{MouseEvent.class}, (MouseEvent) null);
        assertFalse(mainMenu.isVisible());
    }
    /**
     * Test the logout button MouseClicked functionality
     */
    @Test
    public void testLogoutButtonMouseClicked() {
        invokePrivateMethod("logoutButton_MenuMouseClicked", new Class[]{MouseEvent.class}, (MouseEvent) null);
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
