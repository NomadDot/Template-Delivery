package com.example.shushshop;

import android.widget.ImageView;

public class SushiObject {

    private String name;
    private String price;
    private int count;
    private String describe;
    private int image = 0;

    public SushiObject(String name, String price) {
        this.name = name;
        this.price = price;
        this.count = 1;
    }

    public SushiObject(String name, String price, int drawableImage) {
        this.name = name;
        this.price = price;
        this.count = 1;
        image = drawableImage;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public String getDescribe() {
        return describe;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
