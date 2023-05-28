package asu.onlinebankinggui.DataClasses;

public record AccountData(int number, float balance, String currency, String type) {
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
}