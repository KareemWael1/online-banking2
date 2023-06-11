package asu.onlinebankinggui.source.test;

import asu.onlinebankinggui.source.src.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestUserGetNotifications {

    private static final String USERNAME = "batman";
    private static final String PASSWORD = "pswd";
    static User user  =new User("Bruce", USERNAME, PASSWORD);

    User user1 = new User("x","y","z");


    @BeforeAll
    static void setUp() {
        user.login( USERNAME, PASSWORD);
    }

    @AfterEach
    void breakUp(){
        user.logout();
    }

    @Test
    public void testNoNotifications(){
        user.login("y","z");
        assertEquals(0, user1.getNotifications().size());
    }
    @Test
    public void testReceiveNotifications(){
        user1.login("y","z");
        user1.createAccount("EGP", "Checking");
        assertEquals(1, user1.getNotifications().size());

        user1.createAccount("EGP", "Checking");
        assertEquals(2, user1.getNotifications().size());
    }
}
