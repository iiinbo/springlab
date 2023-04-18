package com.kbstar.tv;

import com.kbstar.frame.TV;

public class LTV implements TV {
    @Override
    public void turnOn() {
        System.out.println("엘지티비 켜짐");
    }

    @Override
    public void turnOff() {

    }
}
