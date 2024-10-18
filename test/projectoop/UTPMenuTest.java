package projectoop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UTPMenuTest {
    
    private UTPMenu utpMenu;
    private final String validNIK = "1234567890086123"; // Example valid NIK
    private final String invalidNIK = "invalidNIK"; // Example invalid NIK

    @Before
    public void setUp() {
        // Initialize the UTPMenu with a predefined user ID (13)
        utpMenu = new UTPMenu(13);
    }

    /**
     * Test that the NIK is updated successfully when a valid NIK is provided
     */
    @Test
    public void testContinueButtonSuccess() {
        utpMenu.nikTextField_UTP.setText(validNIK);
        
        // Simulate clicking the continue button
        utpMenu.continueButton_UTP.doClick();

       
    }

    /**
     * Test that an error message is shown when an invalid NIK is provided
     */
    @Test
    public void testContinueButtonInvalidNIK() {
        utpMenu.nikTextField_UTP.setText(invalidNIK);
        
        // Simulate clicking the continue button
        utpMenu.continueButton_UTP.doClick();

        // Verify that a warning message is displayed
       
    }

    /**
     * Test that an error message is shown when no NIK is provided
     */
    @Test
    public void testContinueButtonEmptyNIK() {
        utpMenu.nikTextField_UTP.setText("");
        
        // Simulate clicking the continue button
        utpMenu.continueButton_UTP.doClick();

        // Verify that a warning message is displayed for missing information
        
    }

    /**
     * Test the back button functionality to verify the correct behavior
     */
    @Test
    public void testBackButtonFunctionality() {
        JButton backButton = utpMenu.backButton_UTP;
        // Simulate clicking the back button
        backButton.doClick();
        
        // Verify that the main menu is displayed
        // This will depend on how you manage the main menu, adjust accordingly
        // assertTrue(isMainMenuVisible()); // Implement isMainMenuVisible() accordingly
    }

    /**
     * Helper method to retrieve the last message displayed by JOptionPane
     */
}
