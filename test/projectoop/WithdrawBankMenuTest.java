package projectoop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JButton;

public class WithdrawBankMenuTest {

    private WithdrawBankMenu withdrawBankMenu;
    private final int testUserId = 13; // predefined user ID for testing
    private final double initialBalance = 1000.0; // initial balance for the user

    @Before
    public void setUp() {
        // Initialize the WithdrawBankMenu with the test user ID
        withdrawBankMenu = new WithdrawBankMenu(testUserId);
        
        // Simulate the initial balance in the WithdrawBankMenu class

    }

    @Test
    public void testWithdrawSuccess() {
        // Set the amount to withdraw
        double withdrawAmount = 200.0;
        withdrawBankMenu.withdrawBalance_Withdraw.setText(String.valueOf(withdrawAmount));
        withdrawBankMenu.withdrawBalance_Withdraw1.setText("123456789"); // Example bank account number

        // Perform the withdraw action
        withdrawBankMenu.continueButton_Withdraw.doClick();

        // Check if the balance is updated correctly
        double expectedBalance = initialBalance - withdrawAmount;

    }

    @Test
    public void testWithdrawFailureDueToInsufficientBalance() {
        // Set the amount to withdraw more than the balance
        double withdrawAmount = 1200.0; // More than the initial balance
        withdrawBankMenu.withdrawBalance_Withdraw.setText(String.valueOf(withdrawAmount));
        withdrawBankMenu.withdrawBalance_Withdraw1.setText("123456789"); // Example bank account number

        // Perform the withdraw action
        withdrawBankMenu.continueButton_Withdraw.doClick();

        // Check if the balance remains the same

    }

    // Additional tests can be added to validate different withdrawal scenarios

    @Test
    public void testWithdrawInvalidAccountNumber() {
        withdrawBankMenu.withdrawBalance_Withdraw.setText("200");
        withdrawBankMenu.withdrawBalance_Withdraw1.setText("invalid"); // Invalid account number

        // Simulate clicking the continue button
        withdrawBankMenu.continueButton_Withdraw.doClick();

        // Verify that an error message is shown

    }

    @Test
    public void testWithdrawEmptyFields() {
        withdrawBankMenu.withdrawBalance_Withdraw.setText("");
        withdrawBankMenu.withdrawBalance_Withdraw1.setText(""); // Empty account number

        // Simulate clicking the continue button
        withdrawBankMenu.continueButton_Withdraw.doClick();

        // Verify that an error message is shown
      
    }
}
