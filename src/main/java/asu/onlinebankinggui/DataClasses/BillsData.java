package asu.onlinebankinggui.DataClasses;

public record BillsData(String bill, float price) {
    public String getBill(){
        return bill;
    }
    public float getPrice(){
        return price;
    }
}
