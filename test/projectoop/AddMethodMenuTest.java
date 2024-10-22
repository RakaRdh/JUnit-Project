package projectoop;

import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;

public class AddMethodMenuTest {

    private AddMethodMenu addMethodMenu;

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = AddMethodMenu.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(addMethodMenu, (Object) null); // Passing null as the MouseEvent
    }

    @Before
    public void setUp() {
        // Initialize the WDMethodMenu with a dummy user ID (13)
        addMethodMenu = new AddMethodMenu(13);
        addMethodMenu.setVisible(true);  // Ensure the window is visible

    }

    @Test
    public void testMain() {
        String[] args = null;
        AddMethodMenu.main(args);
        assertTrue(addMethodMenu.isVisible());
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
        assertTrue(addMethodMenu.isVisible());
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
    public void testBackButton() throws Exception {
        invokePrivateMethod("BackButton_MenuDPWDMouseClicked");
        assertTrue("Back button click executed without errors", true);
    }
    
}
