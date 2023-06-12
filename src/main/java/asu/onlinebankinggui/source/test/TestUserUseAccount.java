package asu.onlinebankinggui.source.test;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import asu.onlinebankinggui.source.src.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserUseAccount {
    static User user;
    private static final String USERNAME = "batman";
    private static final String PASSWORD = "pswd";

    @BeforeAll
    static void setUp() {
        user =  new User("Bruce", USERNAME, PASSWORD);
    }

    @AfterEach
    void breakUp(){
        user.logout();
    }

    @Test
    public void testCorrectUseAccount() {
        User user1 = new User("x","y","z");
        assertTrue(user1.login("y", "z"));
        assertTrue(user1.createAccount("EGP", "Checking"));
        int acc1 = user1.getAccountNums().get(0);
        assertTrue(user1.useAccount(acc1));
    }
    @Test
    public void testUnableUseAccount() {
        User user1 = new User("x","y","z");
        assertTrue(user1.login("y", "z"));
        assertTrue(user1.createAccount("EGP", "Checking"));
        int acc1 = user1.getAccountNums().get(0);
        assertTrue(user1.useAccount(acc1));


        User user2 = new User("temp","temp","temp");
        user2.login("temp","temp");
        user2.createAccount("EGP", "Checking");
        int acc2 = user2.getAccountNums().get(0);
        assertFalse(user2.useAccount(acc1));
        assertTrue(user2.useAccount(acc2));
    }
}

