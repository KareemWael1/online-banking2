package asu.onlinebankinggui.source.test;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import asu.onlinebankinggui.source.src.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUserLogout {
    private static final String USERNAME = "batman";
    private static final String PASSWORD = "pswd";
    static User user = new User("Bruce", USERNAME, PASSWORD);


    @BeforeEach
    static void setUp() {
        user.login(USERNAME,PASSWORD);
    }

    @AfterEach
    void breakUp(){
        user.logout();
    }


    @Test
    public void SuccLogout() {
        user.login(USERNAME, PASSWORD);
        assertTrue(user.isLoggedIn());
    }
    @Test
    public void FailedLogout() {
        user.logout();
        assertFalse(user.isLoggedIn());
    }
}
