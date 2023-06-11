package asu.onlinebankinggui.source.test;

import static org.junit.Assert.*;

import org.junit.Test;

import asu.onlinebankinggui.source.src.*;

public class TestUserGetName {

    @Test
    public void checkName(){
        User user = new User("Bruce","b","f");
        assertSame("Bruce", user.getName());
    }
}
