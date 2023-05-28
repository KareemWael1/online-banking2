package asu.onlinebankinggui.DataClasses;

import java.time.LocalDateTime;

public record TransactionData(int id, float amount, String currency, String type, int fromAccountNumber, LocalDateTime date) {
    public int getId(){
        return id;
    }
    public float getAmount(){

        return amount;
    }
    public String getType(){
        return type;
    }
    public String getCurrency(){
        return currency;
    }
    public int getFromAccountNumber() {

        return fromAccountNumber;
    }
    public LocalDateTime getDate(){
        return date;
    }
}
