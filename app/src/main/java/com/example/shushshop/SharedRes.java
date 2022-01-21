package com.example.shushshop;

import java.util.ArrayList;
import java.util.HashMap;

public class SharedRes {
    private ArrayList<SushiObject> sushiObjects = new ArrayList<>();

    public ArrayList<SushiObject> getSushiObjects() {
        return sushiObjects;
    }

    public void setSushiObjects(SushiObject sushiObject) {
        this.sushiObjects.add(sushiObject);
    }
}
