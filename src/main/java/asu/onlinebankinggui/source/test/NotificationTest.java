package asu.onlinebankinggui.source.test;

import asu.onlinebankinggui.DataClasses.NotificationData;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import asu.onlinebankinggui.source.src.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NotificationTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetData() {
        String message = "Hello, World!";
        Notification notification = new Notification(message);

        NotificationData data = notification.getData();
        assertNotNull(data);
        assertEquals(message, data.getMessage());
        assertNotNull(data.getDateSent());
    }

    @Test
    public void testGetMessage() {
        String message = "Hello, World!";
        Notification notification = new Notification(message);

        String actualMessage = notification.getData().getMessage();
        assertEquals(message, actualMessage);
    }

    @Test
    public void testGetDateSent() {
        String message = "Hello, World!";
        Notification notification = new Notification(message);

        assertNotNull(notification.getData().getDateSent());
    }

    @Test
    public void testGetNotificationDataNotNull() {
        String message = "Hello, World!";
        Notification notification = new Notification(message);

        NotificationData actualNotificationData = notification.getData();
        assertNotNull(actualNotificationData);
    }

    @Test
    public void testGetNotificationData() {
        String message = "Hello, World!";
        Notification notification = new Notification(message);

        NotificationData actualNotificationData = notification.getData();
        assertNotNull(actualNotificationData);
        assertEquals(message, actualNotificationData.getMessage());
        assertNotNull(actualNotificationData.getDateSent());
    }
}
