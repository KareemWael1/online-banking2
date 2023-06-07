package asu.onlinebankinggui.DataClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class DataClassStub {
//
//    public static ArrayList<InventoryData> InventoryStub(){
//        ArrayList<InventoryData> returnValue = new ArrayList<>();
//        returnValue.add(new InventoryData("xxx", 2));
//        returnValue.add(new InventoryData("yyy", 1));
//        returnValue.add(new InventoryData("zzz", 10));
//        return returnValue;
//    }
//
//
//    public static ArrayList<AccountData> AccountsStub(){
//        ArrayList<AccountData> accountsArray = new ArrayList<>();
//        accountsArray.add(new AccountData(26376, 30000, "EGP", "Saving"));
//        accountsArray.add(new AccountData(67688, 5000, "USD", "Checking"));
//        accountsArray.add(new AccountData(99999, 2400.65f, "EGP", "Saving"));
//        return accountsArray;
//    }
//
//    public static ArrayList<NotificationData> NotificationStub(){
//        ArrayList<NotificationData> notificationData = new ArrayList<>();
//        notificationData.add(new NotificationData("Bill#313 with total 500EGP demands Payment", LocalDateTime.of(2020, Month.JANUARY, 1, 10, 10, 30)));
//        notificationData.add(new NotificationData("Bill#313 is paid successfully", LocalDateTime.of(2020, Month.FEBRUARY, 15, 22, 35, 12)));
//        notificationData.add(new NotificationData("An amount of 1000EGP Transferred to your account", LocalDateTime.of(2022, Month.JULY, 3, 12, 0, 0)));
//        return notificationData;
//    }
//
    public static ArrayList<BillsData> BillsStub(){
        ArrayList<BillsData> returnValue = new ArrayList<>();
        returnValue.add(new BillsData("Bill#313", 500));
        returnValue.add(new BillsData("Bill#505", 2000));
        returnValue.add(new BillsData("Bill#1001", 100));
        return returnValue;
    }
//
//    public static ArrayList<TransactionData> TransactionsStub(){
//        ArrayList<TransactionData> transactionData = new ArrayList<>();
//        transactionData.add(new TransactionData(2233,500, "EGP", "Deposit", 26376, LocalDateTime.of(2021, Month.DECEMBER, 15, 22, 35, 12)));
//        transactionData.add(new TransactionData(20000, 2000, "USD", "Transfer", 26376, LocalDateTime.of(2019, Month.OCTOBER, 22, 6, 12, 0)));
//        transactionData.add(new TransactionData(99999, 300.5f, "EGP", "Withdraw", 26376, LocalDateTime.of(2016, Month.APRIL, 1, 0, 0, 0)));
//        return transactionData;
//    }
//
//    public static ArrayList<ItemsData> getAvailableItems(){
//        ArrayList<ItemsData> items = new ArrayList<>();
//        items.add(new ItemsData("xxx", 250));
//        items.add(new ItemsData("yyy", 1000));
//        items.add(new ItemsData("zzz", 49.99f));
//        return items;
//    }
}
