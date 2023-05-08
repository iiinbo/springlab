package com.kbstar.controller;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CartService;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import com.kbstar.util.FileUploadUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxImplController {
    @Autowired
    MarkerService markerService;
    @Autowired
    CustService custService;
    @Autowired
    CartService cartService;

    @Value("${uploadimgdir}") // 이미지 즉시 저장경로
    String imgdir;

    @RequestMapping("/saveimg")
    public String saveimg(MultipartFile file){
        String filename = file.getOriginalFilename(); // 이미지 올라오면 이름 다시 등록하기
        FileUploadUtil.saveFile(file, imgdir); // 그 다음 저장.
        return filename;
    }
    @RequestMapping("/getservertime")
    public Object getservertime(){
      Date date = new Date();
      return date;
    };

    @RequestMapping("/checkid")
    public Object checkid(String id) throws Exception {
        int result = 0;
        Cust cust = null;
        cust = custService.get(id);
        if(cust != null){
            result =1;
        }
        return result;
    }

    @RequestMapping("/getdata")
    public Object getdata(){
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01","pwd01","james1"));
        list.add(new Cust("id02","pwd02","james2"));
        list.add(new Cust("id03","pwd03","james3"));
        list.add(new Cust("id04","pwd04","james4"));
        list.add(new Cust("id05","pwd05","james5"));
        list.add(new Cust("id06","pwd06","james6"));

        // JSON Object ----> JSON
        // JSON(JavaScript Object Natation)
        // [{},{},{},.......]
        JSONArray ja = new JSONArray();
        for(Cust obj:list){
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100)+1;
            jo.put("id",obj.getId());
            jo.put("pwd",obj.getPwd());
            jo.put("name",obj.getName()+i);
;           ja.add(jo);
        }
        return ja;
    }
    @RequestMapping("/markers")
    public Object markers(String loc) throws Exception {
        List<Marker> list = null;
        try {
            list = markerService.getLoc(loc);
        } catch (Exception e) {
            throw new Exception("시스템 장애 : ER0003");
        }

        JSONArray ja = new JSONArray();
        for(Marker obj:list){
            JSONObject jo = new JSONObject();
            jo.put("id",obj.getId());
            jo.put("title",obj.getTitle());
            jo.put("target",obj.getTarget());
            jo.put("lat",obj.getLat());
            jo.put("lng",obj.getLng());
            jo.put("img",obj.getImg());
            jo.put("loc",obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }

    // 카트 추가하면 본 페이지에 남도록 ajax로 정보 보내보기.
    @RequestMapping("/addcart")
    public Object addcart(Cart cart) throws Exception {
        cartService.register(cart);
        return ""; // 낫띵.
    };

}
