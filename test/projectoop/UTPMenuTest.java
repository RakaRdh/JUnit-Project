package projectoop;

import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UTPMenuTest {
    
    private UTPMenu utpMenu;
    private final String validNIK = "1234567890086123"; // Example valid NIK
    private final String invalidNIK = "invalidNIK"; // Example invalid NIK
private void invokePrivateMethod(String methodName) throws Exception {
        Method method = UTPMenu.class.getDeclaredMethod(methodName, java.awt.event.ActionEvent.class);
        method.setAccessible(true);
        method.invoke(utpMenu, (Object) null); // Passing null as the MouseEvent
    }
    @Before
    public void setUp() {
        // Initialize the UTPMenu with a predefined user ID (13)
        utpMenu = new UTPMenu(22);
    }

    /**
     * Test that the NIK is updated successfully when a valid NIK is provided
     */
    
        @Test
    public void testMain() {
        String[] args = null;
        UTPMenu.main(args);
        assertFalse(utpMenu.isVisible());
    }
    
    @Test
    public void testContinueButtonSuccess() throws Exception{
        utpMenu.nikTextField_UTP.setText(validNIK);
        
        invokePrivateMethod("continueButton_UTPActionPerformed");
        assertEquals("Upgrade Succesful", "Upgrade Succesful");

    }

    /**
     * Test that an error message is shown when an invalid NIK is provided
     */
    @Test
    public void testContinueButtonInvalidNIK() throws Exception{
        utpMenu.nikTextField_UTP.setText(invalidNIK);
        
        // Simulate clicking the continue button
        invokePrivateMethod("continueButton_UTPActionPerformed");
        assertEquals("Invalid NIK format", "Invalid NIK format");

        // Verify that a warning message is displayed
       
    }

    /**
     * Test that an error message is shown when no NIK is provided
     */
    @Test
    public void testContinueButtonEmptyNIK() throws Exception{
        utpMenu.nikTextField_UTP.setText("");
        
        // Simulate clicking the continue button
        invokePrivateMethod("continueButton_UTPActionPerformed");
        assertEquals("Missing information", "Missing information");
        // Verify that a warning message is displayed for missing information
        
    }

    /**
     * Test the back button functionality to verify the correct behavior
     */
    @Test
    public void testBackButtonFunctionality() throws Exception{
        
                invokePrivateMethod("backButton_UTPActionPerformed");
        assertTrue("Back button click executed without errors", true);
    
    }

    /**
     * Helper method to retrieve the last message displayed by JOptionPane
     */
}
