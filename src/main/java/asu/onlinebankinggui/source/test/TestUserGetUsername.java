package asu.onlinebankinggui.source.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;

import asu.onlinebankinggui.source.src.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserGetUsername {

    private static final String USERNAME = "batman";
    private static final String PASSWORD = "pswd";
    static User user =  new User("Bruce", USERNAME, PASSWORD);

    @BeforeAll
    static void setUp() {
        user =  new User("Bruce", USERNAME, PASSWORD);
    }

    @AfterEach
    void breakUp(){
        user.logout();
    }

    @Test
    public void checkUsername(){
        assertEquals(USERNAME, user.getUsername());
    }
}
