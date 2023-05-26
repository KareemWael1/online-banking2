package asu.onlinebankinggui.DataClasses;

public record InventoryData(String itemName,int count) {
    public String getItemName(){
        return itemName;
    }
    public int getCount(){
        return count;
    }
}
