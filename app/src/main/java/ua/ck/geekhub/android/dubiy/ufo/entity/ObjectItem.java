package ua.ck.geekhub.android.dubiy.ufo.entity;

/**
 * Created by Gary on 26.10.2014.
 */
public class ObjectItem {
    public int itemId;
    public String itemName;

    public ObjectItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return this.itemName;
    }
/*
    public long getItemId() {
        return this.itemId;
    }
    */
}
