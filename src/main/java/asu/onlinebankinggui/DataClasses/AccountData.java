package asu.onlinebankinggui.DataClasses;

public record AccountData(String username, int number, float balance, String type, String currency) {
    public int getNumber() {
        return number;
    }
    public float getBalance() {
        return balance;
    }
    public String getType() {
        return type;
    }
    public String getCurrency() {
        return currency;
    }
    public String getUsername() {
        return username;
    }
}