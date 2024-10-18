/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Raka
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({projectoop.ShowTransactionTest.class, projectoop.ViewProfileMenuTest.class, projectoop.AddBalanceCashMenuTest.class, projectoop.WithdrawCashMenuTest.class, projectoop.LoginTest.class, projectoop.WithdrawBankMenuTest.class, projectoop.AddMethodMenuTest.class, projectoop.AccountTest.class, projectoop.RegistersCobaTest.class, projectoop.MainMenuTest.class, projectoop.WDMethodMenuTest.class, projectoop.TransferBalanceMenuTest.class, projectoop.icon.IconSuite.class, projectoop.ValidationTest.class, projectoop.AddBalanceBankMenuTest.class, projectoop.UTPMenuTest.class})
public class ProjectoopSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
