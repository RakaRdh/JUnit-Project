/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account("JohnDoe", "Standard", "john.doe@example.com", "1234567890", 1000.0, "password123");
    }

    @Test
    public void testGetUsername() {
        assertEquals("JohnDoe", account.getUsername());
    }

    @Test
    public void testSetUsername() {
        account.setUsername("JaneDoe");
        assertEquals("JaneDoe", account.getUsername());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", account.getEmail());
    }

    @Test
    public void testSetEmail() {
        account.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", account.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("1234567890", account.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        account.setPhoneNumber("0987654321");
        assertEquals("0987654321", account.getPhoneNumber());
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000.0, account.getBalance(), 0.0);
    }

    @Test
    public void testSetBalance() {
        account.setBalance(1500.0);
        assertEquals(1500.0, account.getBalance(), 0.0);
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", account.getPassword());
    }

    @Test
    public void testSetPassword() {
        account.setPassword("newpassword123");
        assertEquals("newpassword123", account.getPassword());
    }

    @Test
    public void testGetType() {
        assertEquals("Standard", account.getType());
    }

    @Test
    public void testSetType() {
        account.setType("Premium");
        assertEquals("Premium", account.getType());
    }
}
