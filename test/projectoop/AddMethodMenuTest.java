package projectoop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Test class for AddMethodMenu
 */
public class AddMethodMenuTest {
    private AddMethodMenu addMethodMenu;

    @Before
    public void setUp() {
        // Initialize AddMethodMenu with a sample idUser
        addMethodMenu = new AddMethodMenu(13); 
    }

    /**
     * Test that the frame is initialized and set to visible
     */
    @Test
    public void testFrameInitialization() {
        assertNotNull(addMethodMenu);
        assertTrue(addMethodMenu.isVisible());
    }

    /**
     * Test the behavior when the Bank button is clicked
     */
    @Test
    public void testBankMenuButtonClick() {
        JButton bankButton = addMethodMenu.Bank_MenuDP;
        
        // Simulate the button click
        bankButton.doClick();

        // After clicking, the current window should be disposed and the new window for bank deposit should be displayed
        assertFalse(addMethodMenu.isVisible());
        // Further assertions can be made if you can check the new window (like checking that AddBalanceBankMenu is launched)
    }

    /**
     * Test the behavior when the Cash button is clicked
     */
    @Test
    public void testCashMenuButtonClick() {
        JButton cashButton = addMethodMenu.Cash_MenuDP;
        
        // Simulate the button click
        cashButton.doClick();

        // After clicking, the current window should be disposed and the new window for cash deposit should be displayed
        assertFalse(addMethodMenu.isVisible());
        // Further assertions can be made if you can check the new window (like checking that AddBalanceCashMenu is launched)
    }

    /**
     * Test the behavior when the Back button is clicked
     */
    @Test
    public void testBackButtonClick() {
        JButton backButton = addMethodMenu.BackButton_MenuDPWD;
        
        // Simulate the button click
        backButton.doClick();

        // After clicking, the current window should be disposed and MainMenu should be displayed
        assertFalse(addMethodMenu.isVisible());
        // Further assertions can be made if you can check the new window (like checking that MainMenu is launched)
    }

    /**
     * Test the main method to ensure the window is displayed
     */
    @Test
    public void testMainMethod() {
        String[] args = null;
        AddMethodMenu.main(args);

        // Test if the main method successfully creates and displays the frame
        JFrame frame = new AddMethodMenu();
        assertNotNull(frame);
        assertTrue(frame.isVisible());
    }
}
