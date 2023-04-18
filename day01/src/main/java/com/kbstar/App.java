package com.kbstar;

import com.kbstar.frame.TV;
import com.kbstar.tv.STV;

public class App {
    public static void main(String args[]){
        TV tv = new STV(); // 지금은 tv 생산된거 하나도 없지만 -> 나중에 드디어 삼성/엘지티비 만들어 짐.
        tv.turnOn(); // 나중에 만든 tv 여기서 킬 수 있따.
    }
}
