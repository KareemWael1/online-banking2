package asu.onlinebankinggui.source.test;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import asu.onlinebankinggui.source.src.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserLoggedIn {

    private static final String USERNAME = "batman";
    private static final String PASSWORD = "pswd";
    static User user = new User("Bruce", USERNAME, PASSWORD);




    @AfterEach
    void breakUp(){
        user.logout();
    }
    @Test
    public void testIsNotLoggedIn(){
        user.logout();
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testLoggedIn(){
        user.login(USERNAME, PASSWORD);
        assertTrue(user.isLoggedIn());
    }
    @Test
    public void testLoggingOut(){
        user.logout();
        assertFalse(user.isLoggedIn());
    }
    @Test
    public void testUnseccLogin(){
        user.login(USERNAME, "Pswd");
        assertFalse(user.isLoggedIn());
    }
}
