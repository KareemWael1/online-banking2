package asu.onlinebankinggui.source.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTestSuite.class,
        BillTest.class,
        ItemTest.class,
        BuyableTest.class,
        NotificationTest.class,
        TransactionTest.class,
        AccountTest.class,
        ShopTestSuite.class
})
public class ProjectTestSuite { }