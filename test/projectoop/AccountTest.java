/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// Test class for Account
public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        // Set up an account instance before each test
        account = new Account("Raka Herdika", "Premium", "raka@example.com", "081212653542", 17500, "123");
    }

    @Test
    public void testGetUsername() {
        assertEquals("Raka Herdika", account.getUsername());
    }

    @Test
    public void testSetUsername() {
        account.setUsername("RakaRdh");
        assertEquals("RakaRdh", account.getUsername());
    }

    @Test
    public void testGetEmail() {
        assertEquals("raka@example.com", account.getEmail());
    }

    @Test
    public void testSetEmail() {
        account.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", account.getEmail());
    }

    @Test
    public void testGetBalance() {
        assertEquals(17500, account.getBalance(), 0);
    }

    @Test
    public void testSetBalance() {
        account.setBalance(20000);
        assertEquals(20000, account.getBalance(), 0);
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("081212653542", account.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        account.setPhoneNumber("082145000123");
        assertEquals("082145000123", account.getPhoneNumber());
    }

    @Test
    public void testGetPassword() {
        assertEquals("123", account.getPassword());
    }

    @Test
    public void testSetPassword() {
        account.setPassword("newpassword");
        assertEquals("newpassword", account.getPassword());
    }

    @Test
    public void testGetType() {
        assertEquals("Premium", account.getType());
    }

    @Test
    public void testSetType() {
        account.setType("Regular");
        assertEquals("Regular", account.getType());
    }
}
