package asu.onlinebankinggui.source;

import asu.onlinebankinggui.DataClasses.AccountData;

import java.util.ArrayList;
import java.util.List;

class Account {
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private static int counter = 0;
    private final int number;
    private float balance;
    private final String currency;
    private final String type;
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private final User user;

    // Constructor
    Account(User user, String currency, String type) {
        number = counter++;
        balance = 0;
        this.user = user;
        if (!currency.equals("EGP") && !currency.equals("USD"))
            throw new IllegalArgumentException(String.format("Currency must be EGP or USD not %s", currency));

        if (!type.equals("Checking") && !type.equals("Savings"))
            throw new IllegalArgumentException(String.format("Type must be Checking or Savings not %s", type));

        this.currency = currency;
        this.type = type;
        accounts.add(this);
    }


    // Static functions
    static Account getAccountByNumber(int number) {
        for(Account account : accounts)
            if (account.getNumber() == number)
                return account;
        return null;
    }



    // Money functions
    public void deposit(float amount) {
        balance += amount;
    }
    public boolean withdraw(float amount) {
        float newBalance = balance - amount;
        if (newBalance < 0) {
            return false;
        }

        balance = newBalance;
        return true;
    }

    // Transaction functions
    public void transact(float amount, int otherAccountNumber) {
        Account other = getAccountByNumber(otherAccountNumber);
        if (other == null)
            throw new IllegalArgumentException(String.format("Account with number %d does not exist", otherAccountNumber));

        transactions.add(new Transaction(amount, this.getNumber(), otherAccountNumber));
    }
    public void transact(float price, String name) {
        if (!Shop.itemExisted(name))
            throw new IllegalArgumentException(String.format("Item with name %s does not exist", name));

        transactions.add(new Transaction(this.getNumber(), name));
    }


    // getters
    public float getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public String getUsername() {
        return user.getUsername();
    }
    public int getNumber() {
        return number;
    }
    public String getType() {
        return type;
    }
    public String getCurrency() {
        return currency;
    }

    public AccountData getData() {
        return new AccountData(
                number,
                balance,
                type,
                currency
        );
    }
}