package asu.onlinebankinggui.source.test;

import org.junit.Test;
import asu.onlinebankinggui.source.src.*;

import static org.junit.Assert.assertSame;

public class TestUserGetName {

    @Test
    public void checkName(){
        User user = new User("Bruce","b","f");
        assertSame("Bruce", user.getName());
    }
}
