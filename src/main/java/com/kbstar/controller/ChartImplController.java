package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController // ajax에서 요청이 들어오면 그 요청을 받고 전달하는 곳! @RestController
public class ChartImplController {


    //DB에 있는 정보를 json으로 바꿔 보내주기
    @RequestMapping("/chart02")
    public Object chart02() { //

        // java -> json으로
        // JSON 의미 : 자바스크립트 오브젝트 노테이션
        // JSONArray 모습 : [ , , ,  ] 이 모양이라, jsonobject는 안해도됨. 더 간단
        // 차트에서 보여줄 내용 = {'category' : [나라명, 나라명 ...], 'datas' : [숫자, 숫자...] }
        JSONObject jo = new JSONObject(); //{}는 1개 
        JSONArray jaCnt = new JSONArray(); // 배열 2개 필요

        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt(10000) + 1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for (int i = 2011; i <= 2023; i++) {
            jaYear.add(i); //한 해씩 증가하며 data 들어간다.
        }
        jo.put("category", jaYear);
        jo.put("datas", jaCnt);
        // 차트에서 보여줄 내용 = {'category' : [나라명, 나라명 ...], 'datas' : [숫자, 숫자...] }

        return jo; // 리턴값 : ajax가 아니라, 여기선 반대로 json을 배출
    }

    //
    @RequestMapping("/chart0301")
    public Object chart0301() {
        // java -> json으로
        // JSON 의미 : 자바스크립트 오브젝트 노테이션
        // JSONArray 모습 : [ [], [],[] ,  ] 이 모양

        JSONArray ja = new JSONArray(); // 1. 가장 바깥 배열 
        for (int i = 1; i <= 5; i++) {
            Random r = new Random();
            int num = r.nextInt(20) + 1;
            JSONArray jadata = new JSONArray(); // 1. 안에 배열
            jadata.add("data : " + num);
            jadata.add(num); // 안에 배열에 랜덤숫자 넣고,

            ja.add(jadata); // 바깥배열 속에 집어넣기.
        }

        return ja; // 리턴값 은배열 : ajax가 아니라, 여기선 반대로 json을 배출
    }

    @RequestMapping("/chart0302")
    public Object chart0302() {
        // java -> json으로
        // JSON 의미 : 자바스크립트 오브젝트 노테이션
        // JSONArray 모습 : [ [], [],[] ,  ] 이 모양

        JSONArray ja = new JSONArray(); // 1. 가장 바깥 배열
        for (int i = 1; i <= 7; i++) {
            Random r = new Random();
            int num = r.nextInt(20) + 1;
            JSONArray jadata = new JSONArray(); // 1. 안에 배열
            jadata.add("data : " + num);
            jadata.add(num); // 안에 배열에 랜덤숫자 넣고,

            ja.add(jadata); // 바깥배열 속에 집어넣기.
        }

        return ja; // 리턴값 은배열 : ajax가 아니라, 여기선 반대로 json을 배출
    }

    @RequestMapping("/chart0303")
    public Object chart0303() {
        // java -> json으로
        // JSON 의미 : 자바스크립트 오브젝트 노테이션
        // JSONArray 모습 : { [], [],[] ,  } 이 모양

        JSONObject jo = new JSONObject(); //{}는 1개 : 오브젝트

        JSONArray ja01 = new JSONArray(); // 중괄호 안에 배열 총 3개 필요
        JSONArray ja02 = new JSONArray(); // 중괄호 안에 배열 총 3개 필요
        JSONArray ja03 = new JSONArray(); // 중괄호 안에 배열 총 3개 필요
        //1
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt(1000) + 1;
            ja01.add(cnt);
        }
        //2
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt(1000) + 1;
            ja02.add(cnt);
        }
        //3
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt(1000) + 1;
            ja03.add(cnt);
        }
        // {} 안에 3개 [] 배열 넣는 중
        jo.put("datas1", ja01);
        jo.put("datas2", ja02);
        jo.put("datas3", ja03);

        return jo; // {} 리턴값 : ajax가 아니라, 여기선 반대로 json을 배출

    }

    //
    @RequestMapping("/chart05")
    public Object chart05(String year) { // ajax에서 보내주는 값 : year.
      JSONArray ja = new JSONArray();

      for(int i=1; i<=12; i++){
          Random r = new Random();
          int num = r.nextInt(100)+1;
            ja.add(num); // 랜덤으로 만들어진 12개 숫자를 배열에 집어넣기.
      }
        return ja;
        }

    }

