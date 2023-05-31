package asu.onlinebankinggui.DataClasses;

public record ItemsData(String itemName,float price) {
    public String getItemName(){
        return itemName;
    }
    public float getCount(){
        return price;
    }
}

