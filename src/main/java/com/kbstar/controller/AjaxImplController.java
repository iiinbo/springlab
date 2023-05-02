package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController // ajax에서 요청이 들어오면 그 요청을 받고 전달하는 곳! @RestController
public class AjaxImplController {
    @Autowired
    MarkerService service;
    @Autowired
    CustService custService; // 회원가입 시 id중복확인 위해

    // 서버의 시간 실시간으로 보여주기
    @RequestMapping("/getservertime")
    public Object getservertime(){ // object : 화면(문자) 외에, 다양한 것(server 정보 등)으로 결과 return 가능.
        Date date = new Date();
        return date;
    }
    //id 중복체크
    @RequestMapping("/checkid")
    public Object checkid(String id) throws Exception { // ajax에서 보내주는 값 : id.
       
        Cust cust = null;
        cust = custService.get(id);
       int result = 0; // id 존재 '1', 미존재 '0' 
        
        if(cust != null ){ // cust에 회원정보 id가 있다면,
          result = 1; // 기존재
       }
        return result;
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
    public Object markers(String loc) throws Exception { // ajax에서 보내주는 값 : loc.
        List<Marker> list = null;
        try {
            list = service.getmybob(loc);
        } catch (Exception e) {
            throw new Exception("Marker(맛집추천) 조회 에러 : ER0003 ");
        }
        // 위 3개의 데이터를
        JSONArray ja = new JSONArray(); // array 안에 넣는다.
        for(Marker obj : list){
            JSONObject jo = new JSONObject();

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
