package asu.onlinebankinggui.DataClasses;

public record BillsData(String bill, String price) {
    public String getBill(){
        return bill;
    }
    // public int getItem(){
    //    return item;
    //}
    public String getPrice(){
        return price;
    }
}
