package projectoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WithdrawCashMenuTest {

    private Connection connection;
    private final int testUserId = 13; // predefined user ID for testing
    private final double initialBalance = 1000.0; // initial balance for the user
    private WithdrawBankMenu withdrawBankMenu;

    @Before
    public void setUp() throws Exception {
        // Set up the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/primodb-test", "root", "");
        
        // Create test data in the account table
        String createAccountQuery = "INSERT INTO account (id_account, balance) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(createAccountQuery)) {
            ps.setInt(1, testUserId);
            ps.setDouble(2, initialBalance);
            ps.executeUpdate();
        }
        
        // Initialize the WithdrawBankMenu with the test user ID
        withdrawBankMenu = new WithdrawBankMenu(testUserId);
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
        double actualBalance = getAccountBalance(testUserId);
        
        Assert.assertEquals(expectedBalance, actualBalance, 0.01);
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
        double actualBalance = getAccountBalance(testUserId);
        
        Assert.assertEquals(initialBalance, actualBalance, 0.01);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up the test data
        String deleteAccountQuery = "DELETE FROM account WHERE id_account = ?";
        try (PreparedStatement ps = connection.prepareStatement(deleteAccountQuery)) {
            ps.setInt(1, testUserId);
            ps.executeUpdate();
        }
        
        // Close the database connection
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private double getAccountBalance(int userId) {
        double balance = 0.0;
        String query = "SELECT balance FROM account WHERE id_account = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }
}
