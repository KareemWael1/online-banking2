package asu.onlinebankinggui.source.test;

import org.junit.Test;
import asu.onlinebankinggui.source.src.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserLogin {

    private static final String USERNAME = "batman";
    private static final String PASSWORD = "pswd";
    static User user = new User("Bruce", USERNAME, PASSWORD);



    @Test
    public void testLoginCorrectPass() {
        assertFalse(user.isLoggedIn());
        assertTrue(user.login(USERNAME, PASSWORD));
        assertTrue(user.isLoggedIn());
    }
    @Test
    public void testLoginWrongPass(){
        user.logout();
        assertFalse(user.isLoggedIn());
        assertFalse(user.login(USERNAME, "Pswd"));
        assertFalse(user.isLoggedIn());
    }

}
