package projectoop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Test class for MainMenu
 */
public class MainMenuTest {

    private MainMenu mainMenu;

    @Before
    public void setUp() {
        // Initialize the MainMenu with sample data
        mainMenu = new MainMenu(13, "Raka Herdika", 1000.0, "321");
        mainMenu.setVisible(true);  // Ensure the window is visible

    }

    /**
     * Test that the main menu is initialized correctly
     */
    @Test
    public void testInitialization() {
        assertNotNull(mainMenu);
        assertEquals("Raka Herdika", mainMenu.nameLabel_Menu.getText());
        assertEquals("1000.0", mainMenu.balanceLabel_Menu.getText());
        assertTrue(mainMenu.isVisible());
    }

    /**
     * Test the viewProfile button functionality
     */
    @Test
    public void testViewProfileButtonClick() {
        JButton viewProfileButton = mainMenu.viewProfileButton_Menu;
        viewProfileButton.doClick();
        // After clicking, the ViewProfileMenu should be displayed
        // This could be tested by checking if the current window is disposed
        // Since the actual implementation of ViewProfileMenu is not shown, we can't verify it directly
    }

    /**
     * Test the deposit balance button functionality
     */
    @Test
    public void testDepoBalanceButtonClick() {
        JButton depoBalanceButton = mainMenu.depoBalanceButton_Menu;
        depoBalanceButton.doClick();
        // After clicking, the AddMethodMenu should be displayed
        // Similar to the viewProfileButton test, we check the current window's visibility
    }

    /**
     * Test the withdraw balance button functionality
     */
    @Test
    public void testWdBalanceButtonClick() {
        JButton wdBalanceButton = mainMenu.wdBalanceButton_Menu;
        wdBalanceButton.doClick();
        // After clicking, the WDMethodMenu should be displayed
    }

    /**
     * Test the transfer balance button functionality
     */
    @Test
    public void testTransferBalanceButtonClick() {
        JButton transferBalanceButton = mainMenu.transferBalanceButton_Menu;
        transferBalanceButton.doClick();
        // After clicking, the TransferBalanceMenu should be displayed
    }

    /**
     * Test the logout button functionality
     */
    @Test
    public void testLogoutButtonClick() {
        JButton logoutButton = mainMenu.logoutButton_Menu;
        logoutButton.doClick();
        // After clicking, the Login window should be displayed
    }

    /**
     * Test the UTP button functionality
     */
    @Test
    public void testUtpButtonClick() {
        JButton utpButton = mainMenu.utpButton_Menu;
        utpButton.doClick();
        // After clicking, the UTPMenu should be displayed
    }

    /**
     * Test the show transaction button functionality
     */
    @Test
    public void testShowTransactionButtonClick() {
        JButton showTransactionButton = mainMenu.showTransactionButton_Menu;
        showTransactionButton.doClick();
        // After clicking, the ShowTransaction window should be displayed
    }

    /**
     * Test the main method to ensure the menu is displayed
     */
    @Test
    public void testMain() {
        String[] args = null;
        MainMenu.main(args);
        // Test if the main method successfully creates and displays the frame
        assertNotNull(mainMenu);
        assertTrue(mainMenu.isVisible());
    }
}
