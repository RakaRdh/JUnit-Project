package projectoop;

import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;

public class WDMethodMenuTest {

    private WDMethodMenu wdMethodMenu;

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = WDMethodMenu.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(wdMethodMenu, (Object) null); // Passing null as the MouseEvent
    }
    
    @Before
    public void setUp() {
        // Initialize the WDMethodMenu with a dummy user ID (13)
        wdMethodMenu = new WDMethodMenu(13);
        wdMethodMenu.setVisible(true);
    }

    @Test
    public void testMain() {
        String[] args = null;
        WDMethodMenu.main(args);
        assertTrue(wdMethodMenu.isVisible());
    }
    
    /**
     * Test that the initial user ID is set correctly
     */
    @Test
    public void testInitialUserId() {
        assertEquals(13, wdMethodMenu.idUser);
    }

    /**
     * Test the behavior when the Bank button is clicked
     */
    @Test
    public void testBankMenuButtonAction() throws Exception {
        invokePrivateMethod("Bank_MenuDPMouseClicked");
        assertFalse(wdMethodMenu.isVisible());
        // Further assertions can be made to confirm the new menu is displayed correctly
    }

    /**
     * Test the behavior when the Cash button is clicked
     */
    @Test
    public void testCashMenuButtonAction() {
        JButton cashButton = wdMethodMenu.Cash_MenuDP;
        
        // Simulate a button click for the Cash button
        cashButton.doClick();

        // After clicking, the current window should be disposed, 
        // and the WithdrawCashMenu should be displayed
        assertFalse(wdMethodMenu.isVisible());
        // Additional assertions can be made to check the new menu's visibility
    }

    /**
     * Test the behavior when the Back button is clicked
     */
    @Test
    public void testBackButtonAction() throws Exception{
        invokePrivateMethod("BackButton_MenuDPWDMouseClicked");
        assertTrue("Back button click executed without errors", true);
    }

    /**
     * Test valid account retrieval logic
     */
    
}
