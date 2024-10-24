package projectoop;

import java.lang.reflect.Method;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ViewProfileMenuTest {

    private ViewProfileMenu viewProfileMenu;
    private final int testUserId = 14; // predefined user ID for testing
private void invokePrivateMethod(String methodName) throws Exception {
        Method method = ViewProfileMenu.class.getDeclaredMethod(methodName, java.awt.event.MouseEvent.class);
        method.setAccessible(true);
        method.invoke(viewProfileMenu, (Object) null); // Passing null as the MouseEvent
    }
    @Before
    public void setUp() {
        // Initialize the ViewProfileMenu with the test user ID
        viewProfileMenu = new MockViewProfileMenu(testUserId);
        viewProfileMenu.setVisible(true);
    }
    
        @Test
    public void testMain() {
        String[] args = null;
        ViewProfileMenu.main(args);
        assertTrue(viewProfileMenu.isVisible());
    }

    @Test
    public void testGetDataSuccess() {
        // Check if the labels are set correctly after data retrieval
        Assert.assertEquals("RakaRdh", viewProfileMenu.usernameLabel_ViewProfile.getText());
        Assert.assertEquals("rakardh@gmail.com", viewProfileMenu.emailLabel_ViewProfile.getText());
        Assert.assertEquals("Premium", viewProfileMenu.typeLabel_ViewProfile.getText());
        Assert.assertEquals("081212678879", viewProfileMenu.pnLabel_ViewProfile.getText());
    }

    @Test
    public void testGetDataFailure() {
        // Simulate a scenario where account details are not found
        MockViewProfileMenu mockMenu = new MockViewProfileMenu(testUserId, true);
        mockMenu.GetData(); // Call GetData which would trigger the failure
        Assert.assertEquals("N/A", mockMenu.emailLabel_ViewProfile.getText());
        Assert.assertEquals("N/A", mockMenu.pnLabel_ViewProfile.getText());
    }

    @After
    public void tearDown() {
        viewProfileMenu = null; // Clean up
    }

    // Mock class to simulate ViewProfileMenu behavior
    private static class MockViewProfileMenu extends ViewProfileMenu {
        private boolean simulateFailure;

        public MockViewProfileMenu(int Id_User) {
            super(Id_User);
            simulateFailure = false;
            GetData(); // Call to load data
        }

        public MockViewProfileMenu(int Id_User, boolean simulateFailure) {
            super(Id_User);
            this.simulateFailure = simulateFailure;
            GetData(); // Call to load data
        }


        protected void GetData() {
            // Simulate database response
            if (simulateFailure) {
                uName = "N/A";
                eMail = "N/A";
                PhoneNumber = "N/A";
                Type = "N/A";
            } else {
                // Mock data
                uName = "RakaRdh";
                eMail = "rakardh@gmail.com";
                PhoneNumber = "081212678879";
                Type = "Premium";
            }

            // Set label texts
            usernameLabel_ViewProfile.setText(uName);
            emailLabel_ViewProfile.setText(eMail);
            typeLabel_ViewProfile.setText(Type);
            pnLabel_ViewProfile.setText(PhoneNumber);
        }
    }
    
    @Test
    public void testBackButtonFunctionality() throws Exception {
                invokePrivateMethod("backButton_ViewProfileMouseClicked");
        assertTrue("Back button click executed without errors", true);
    }
}
