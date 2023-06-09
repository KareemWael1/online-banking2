package asu.onlinebankinggui.source.test;

import asu.onlinebankinggui.DataClasses.AccountData;
import asu.onlinebankinggui.DataClasses.BillData;
import asu.onlinebankinggui.source.src.*;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AccountTest {
    static User user;
    static Account acc1;
    static int accNum = 0;
    static float DELTA = 0.0001f;
    private static final String USERNAME = "batman";
    private static final String PASSWORD = "pswd";


    @Before
    public void SetUp() {
        user = new User("ahmed","ahmed","ah");
        acc1 = new Account(user,"EGP","Savings");
        user.login("ahmed","ah");
    }

    @Test
    public void getAccountByNumber() {
       assertNotNull(Account.getAccountByNumber(0));
    }

    @Test
    public void getNonExistingAccountByNumber(){
        assertNull(Account.getAccountByNumber(232));
        assertNull(Account.getAccountByNumber(-2));
    }

    @Test
    public void deposit() {
        acc1.deposit(23);
        assertEquals(23,acc1.getBalance(), DELTA);
    }

    @Test
    public void depositNegative(){
        assertThrows(IllegalArgumentException.class,()->acc1.deposit(-42));
    }

    @Test
    public void withdraw() {
        acc1.deposit(234);
        acc1.withdraw(acc1.getBalance());
        assertEquals(0f, acc1.getBalance(), DELTA);
    }
    @Test
    public void withdrawExceedBalance(){
        acc1.deposit(100);
        assertFalse(acc1.withdraw(200));
    }

    @Test
    public void withdrawNegative(){
        assertThrows(IllegalArgumentException.class,()->acc1.withdraw(-43));
    }


    @Test
    public void transact(){
        Account acc2 = new Account(user,"EGP","Savings");
        acc1.deposit(300);
        acc1.transact(300,acc2.getNumber());
        assertTrue(acc1.getTransactions().size()>=1);
    }
    @Test
    public void transactToNull(){
        acc1.deposit(234);
        assertThrows(IllegalArgumentException.class,()->acc1.transact(200,
                -1));
    }

    @Test
    public void testTransact() {
        Shop.addNewItem("pepsi",12,2);
        acc1.transact("pepsi");
        assertTrue(acc1.getTransactions().size()>=1);
    }
    @Test
    public void transactNonExisting(){
        assertThrows(
                IllegalArgumentException.class,()->acc1.transact("unknown")
        );
    }

    @Test
    public void getBalance() {
        acc1.deposit(33);
        assertEquals(33,acc1.getBalance(), DELTA);
    }

    @Test
    public void getTransactions() {
        Account acc2 = new Account(user,"EGP","Savings");
        acc1.deposit(230);
        acc1.transact(200,acc2.getNumber());
        assertEquals(1, acc1.getTransactions().size());
    }

    @Test
    public void getUsername() {
        assertEquals("ahmed",acc1.getUsername());
    }

    @Test
    public void getNumber() {
        User user = new User("ahmed","ahmed","ah");
        user.login("ahmed","ah");
        user.createAccount("EGP","Savings");
        user.useAccount(user.getAccountNums().get(0));
        int accNum = user.getAccountNumber();
        Account userAcc = Account.getAccountByNumber(accNum);
        assertEquals(accNum, userAcc.getNumber());
    }

    @Test
    public void getType() {
        assertEquals("Savings",acc1.getType());
    }

    @Test
    public void getCurrency() {
        assertEquals("EGP",acc1.getCurrency());
    }

    @Test
    public void getData() {
        AccountData ad = acc1.getData();
        assertEquals(ad.number(), 32);
        assertEquals(ad.currency(), "EGP");
        assertEquals(ad.balance(), 0, DELTA);
        assertEquals(ad.type(), "Savings");
    }

    @Test
    public void addBill() {
        Bill b = new Bill("cola",32,0);
        acc1.addBill(b);
        assertEquals(1, acc1.getBills().size());
    }
    @Test
    public void addBillOtherAccount() {
        Bill b = new Bill("cola",32,-32);
        assertThrows(IllegalArgumentException.class, ()->acc1.addBill(b));
        assertEquals(0, acc1.getBills().size());
    }

    @Test
    public void hasBill() {
        Bill b = new Bill("cola",32,0);
        acc1.addBill(b);
        assertTrue(acc1.hasBill("cola"));
        assertFalse(acc1.hasBill("pepsi"));
    }


    @Test
    public void hasUnpaidBill() {
        Bill b = new Bill("cola",32,0);
        acc1.addBill(b);
        assertTrue(acc1.hasUnpaidBill("cola"));
        assertFalse(acc1.hasUnpaidBill("pepsi"));
    }

    @Test
    public void payBill() {
        Bill b = new Bill("cola",32,0);
        acc1.deposit(32);
        acc1.addBill(b);
        acc1.payBill("cola");
        assertFalse(acc1.hasUnpaidBill("cola"));
    }
    @Test
    public void payBillWithNoBalance(){
        Bill b = new Bill("cola", 32, acc1.getNumber());
        acc1.addBill(b);
        assertTrue(acc1.payBill("cola"));
        assertFalse(acc1.hasUnpaidBill("cola"));
    }

    @Test
    public void payNonExsBill(){
        assertThrows(IllegalArgumentException.class,()->acc1.payBill("cola"));
    }


    @Test
    public void getBills() {
        Bill b = new Bill("cola",32,0);
        acc1.addBill(b);
        assertEquals(1, acc1.getBills().size());
    }

    @Test
    public void getBillsData() {
        Bill b = new Bill("cola",32,0);
        acc1.addBill(b);
        BillData bd = acc1.getBillsData().get(0);
        assertEquals("cola",bd.getName());
        assertEquals(32,bd.getPrice(), DELTA);
        assertEquals(0,bd.accountNumber());
        assertFalse(bd.getIsPaid());

    }
}

