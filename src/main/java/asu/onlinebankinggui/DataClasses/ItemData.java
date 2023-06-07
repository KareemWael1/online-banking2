package asu.onlinebankinggui.DataClasses;

public record ItemData(String itemName, float price, int count) {
    public String getItemName(){
        return itemName;
    }
    public float getPrice(){
        return price;
    }
    public int getCount(){
        return count;
    }
}

