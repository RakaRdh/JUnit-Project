package projectoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {

    private List<Account> accountList;

    @BeforeClass
    public static void setUpClass() {
        // This method runs once before all tests
    }

    @AfterClass
    public static void tearDownClass() {
        // This method runs once after all tests
    }

    @Before
    public void setUp() {
        // Initialize an account list before each test
        accountList = new ArrayList<>();
        accountList.add(new Account("user1", "08123456789"));
        accountList.add(new Account("user2", "08123456788"));
    }

    @After
    public void tearDown() {
        // Clean up after each test
        accountList.clear();
    }

    @Test
    public void testIsUniqueUsername() {
        assertFalse("Username 'user1' should not be unique.", Validation.isUniqueUsername("user1", accountList));
        assertTrue("Username 'newuser' should be unique.", Validation.isUniqueUsername("newuser", accountList));
    }

    @Test
    public void testIsUniquePhoneNumber() {
        assertFalse("Phone number '08123456789' should not be unique.", Validation.isUniquePhoneNumber("08123456789", accountList));
        assertTrue("Phone number '08123456780' should be unique.", Validation.isUniquePhoneNumber("08123456780", accountList));
    }

    @Test
    public void testIsValidBalance() {
        assertTrue("Balance '100' should be valid.", Validation.isValidBalance("100"));
        assertFalse("Balance '0' should be invalid.", Validation.isValidBalance("0"));
        assertFalse("Balance '-100' should be invalid.", Validation.isValidBalance("-100"));
        assertFalse("Balance 'abc' should be invalid.", Validation.isValidBalance("abc"));
    }

    @Test
    public void testIsValidNik_String() {
        assertTrue("NIK '1234567890123456' should be valid.", Validation.isValidNik("1234567890123456"));
        assertFalse("NIK '12345678' should be invalid.", Validation.isValidNik("12345678"));
        assertFalse("NIK 'abcdefg' should be invalid.", Validation.isValidNik("abcdefg"));
    }

    @Test
    public void testIsValidEmail_String() {
        assertTrue("Email 'test@example.com' should be valid.", Validation.isValidEmail("test@example.com"));
        assertFalse("Email 'invalidemail' should be invalid.", Validation.isValidEmail("invalidemail"));
    }

    @Test
    public void testIsValidPhoneNumber_String() {
        assertTrue("Phone number '08123456789' should be valid.", Validation.isValidPhoneNumber("08123456789"));
        assertFalse("Phone number '1234567890' should be invalid.", Validation.isValidPhoneNumber("1234567890"));
    }

    @Test
    public void testIsValidPassword_String() {
        assertTrue("Password 'Password1' should be valid.", Validation.isValidPassword("Password1"));
        assertFalse("Password 'password' should be invalid.", Validation.isValidPassword("password"));
        assertFalse("Password 'PASSWORD' should be invalid.", Validation.isValidPassword("PASSWORD"));
        assertFalse("Password '12345678' should be invalid.", Validation.isValidPassword("12345678"));
    }

    @Test
    public void testIsValidConfirmation_String() {
        assertTrue("Input 'yes' should be valid.", Validation.isValidConfirmation("yes"));
        assertTrue("Input 'no' should be valid.", Validation.isValidConfirmation("no"));
        assertFalse("Input 'maybe' should be invalid.", Validation.isValidConfirmation("maybe"));
    }

    // Note: Testing methods with Scanner input is not straightforward in unit tests
    // Here are some ideas on how to handle them if needed:

    @Test
    public void testIsValidNik_Scanner() {
        // For testing purposes, you'd typically want to mock the Scanner input.
        // Here we can simulate input directly for testing logic.
    }

    @Test
    public void testIsValidEmail_Scanner() {
        // For testing purposes, you'd typically want to mock the Scanner input.
        // Here we can simulate input directly for testing logic.
    }

    @Test
    public void testIsValidPhoneNumber_Scanner() {
        // For testing purposes, you'd typically want to mock the Scanner input.
        // Here we can simulate input directly for testing logic.
    }

    @Test
    public void testIsValidPassword_Scanner() {
        // For testing purposes, you'd typically want to mock the Scanner input.
        // Here we can simulate input directly for testing logic.
    }

    @Test
    public void testIsValidConfirmation_Scanner() {
        // For testing purposes, you'd typically want to mock the Scanner input.
        // Here we can simulate input directly for testing logic.
    }
}
