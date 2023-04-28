package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController // ajax에서 요청이 들어오면 그 요청을 받고 전달하는 곳! @RestController
public class AjaxImplController {
    // 서버의 시간 실시간으로 보여주기
    @RequestMapping("/getservertime")
    public Object getservertime(){ // object : 화면(문자) 외에, 다양한 것(server 정보 등)으로 결과 return 가능.
        Date date = new Date();
        return date;
    }
    //id 중복체크
    @RequestMapping("/checkid")
    public Object checkid(String id){ // ajax에서 보내주는 값 : id.
       int data = 0; // 사용가능한 id는 '0'
        if( id.equals("qqqq")|| id.equals("aaaa")|| id.equals("ssss") ){
           data = 1; // 사용불가한 id는 '1'
       }
        return data;
    }
    //DB에 있는 정보를 json으로 바꿔 보내주기
    @RequestMapping("/getdata")
    public Object getdata(){ //
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01","pwd01","미니")); //dto에 정보 넣기
        list.add(new Cust("id02","pwd02","망고"));
        list.add(new Cust("id03","pwd03","넛지"));
        list.add(new Cust("id04","pwd04","사랑"));
        list.add(new Cust("id05","pwd05","애플"));
        // java -> json으로
        // JSON 의미 : 자바스크립트 오브젝트 노테이션
        // JSONArray 모습 : [{}, {}, {}]
        JSONArray ja = new JSONArray();
        for(Cust obj : list){
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100)+1 ; //1부터 100까지 랜덤 숫자
            jo.put("id", obj.getId() );
            jo.put("pwd", obj.getPwd() );
            jo.put("name", obj.getName()+i ); // 3초마다 업데이트 중인지 test해보려고 random숫자 붙였다.
            ja.add(jo);
        }

        return ja;
    }

    //마커 지역에 따라  설정된 맛집리스트 안내해주기
    @RequestMapping("/markers")
    public Object markers(String loc){ // ajax에서 보내주는 값 : loc.
        List<Marker> list = new ArrayList<>();
        if(loc.equals("s")){
           list.add(new Marker(100,"담미온","http://www.naver.com", 37.5452455, 127.0570455, "a.jpg", "s"));
           list.add(new Marker(101,"제주국수","http://www.naver.com", 37.5452456, 127.0570445, "b.jpg", "s"));
           list.add(new Marker(102,"밥플러스","http://www.naver.com", 37.5452458, 127.0570435, "c.jpg", "s"));

        }else if (loc.equals("b")) {
            list.add(new Marker(201,"싱싱해횟집","http://www.naver.com", 34.5452455, 127.0570455, "d.jpg", "b"));
            list.add(new Marker(202,"빨리와참치집","http://www.naver.com", 33.5452456, 127.0570445, "e.jpg", "b"));
            list.add(new Marker(203,"가지마국밥집","http://www.naver.com", 32.5452458, 127.0570435, "c.jpg", "b"));

        }else if(loc.equals("j")){
            list.add(new Marker(301,"섭지코지옆맛집","http://www.naver.com", 37.5552455, 127.0570455, "a.jpg", "j"));
            list.add(new Marker(302,"고기국수","http://www.naver.com", 37.5452446, 127.0570425, "b.jpg", "j"));
            list.add(new Marker(303,"해녀의집","http://www.naver.com", 37.5452468, 127.0570415, "c.jpg", "j"));

        }

        JSONArray ja = new JSONArray();
        for(Marker obj : list){
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100)+1 ; //1부터 100까지 랜덤 숫자
            jo.put("id", obj.getId() );
            jo.put("title", obj.getTitle() );
            jo.put("target", obj.getTarget() );
            jo.put("lat", obj.getLat() );
            jo.put("lng", obj.getLng() );
            jo.put("img", obj.getImg() );
            jo.put("loc", obj.getLoc() );
            ja.add(jo);
        }
        return ja;
    }
}
