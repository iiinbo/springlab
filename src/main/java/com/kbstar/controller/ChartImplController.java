package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ChartImplController {
    @RequestMapping("/chart02")
    // {'ctegory' : [], 'datas':[]}
    public Object chart02() {
        JSONObject jo = new JSONObject();

        JSONArray jaCnt = new JSONArray();
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt((10000)) + 1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for (int i = 2011; i <= 2023; i++) {
            jaYear.add(i);
        }

        jo.put("category", jaYear);
        jo.put("datas", jaCnt);
        return jo;
    }

    @RequestMapping("/chart0301")
    public Object chart0301() {
        //[[],[],[],[]]
        JSONArray ja = new JSONArray();
        for (int i = 1; i <= 5; i++) {
            Random r = new Random();
            int num = r.nextInt(20) + 1;
            JSONArray jadata = new JSONArray();
            jadata.add("data" + num); //이름
            jadata.add(num);
            ja.add(jadata);
        }
        return ja;
    }

    @RequestMapping("/chart0302")
    public Object chart0302() {
        //[{},{},{},{}]
        JSONObject jo = new JSONObject();

        JSONArray ja01 = new JSONArray();
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt((1000)) ;
            ja01.add(cnt);
        }
        JSONArray ja02 = new JSONArray();
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt((1000)) ;
            ja02.add(cnt);
        }
        JSONArray ja03 = new JSONArray();
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt((1000)) ;
            ja03.add(cnt);
        }
        jo.put("r01", ja01);
        jo.put("r02", ja02);
        jo.put("r03", ja03);
        return jo;
    }

    @RequestMapping("/chart0303")
    public Object chart0303() {
        //[[],[],[],[]]
        JSONArray ja = new JSONArray();
        for (int i = 1; i <= 5; i++) {
            Random r = new Random();
            int num = r.nextInt(200000);
            JSONArray jadata = new JSONArray();
            jadata.add("name" + num); //이름
            jadata.add(num);
            ja.add(jadata);
        }
        return ja;
    }

    @RequestMapping("/chart05")
    public Object chart05(String year){
        JSONArray ja = new JSONArray();
        for(int i=1; i<=12; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja.add(num);
        }
        return ja;
    };
}
