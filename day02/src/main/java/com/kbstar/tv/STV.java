package com.kbstar.tv;

import com.kbstar.frame.TV;

public class STV implements TV {

    @Override
    public void turnOn() {
        System.out.println("삼성티비 켜짐");
    }

    @Override
    public void turnOff() {

    }
}
