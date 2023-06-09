package asu.onlinebankinggui.source.test;

import org.junit.Test;
import asu.onlinebankinggui.source.src.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class ItemTest {

    @Test
    public void testEquals() {
        Item item = new Item("cola",32);
        Item item2 = new Item("cola",32);
        assertEquals(item, item2);
    }

    @Test
    public void testEqualsDiffPrice(){
        Item item = new Item("cola",32);
        Item item2 = new Item("cola",39);
        assertNotEquals(item, item2);
    }

    @Test
    public void testEqualsDiffName(){
        Item item = new Item("pepsi",32);
        Item item2 = new Item("cola",39);
        assertNotEquals(item, item2);
    }

    @Test
    public void testConstructor(){
        assertThrows(IllegalArgumentException.class,()->new Item("cola",-12));
    }
}