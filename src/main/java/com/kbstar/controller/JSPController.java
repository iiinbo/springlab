package com.kbstar.controller;

import com.kbstar.dto.Cust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JSPController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "jsp/"; // 매번, cust 라는 폴더 경로를 붙이기 귀찮을 때.

    // 상단 - jsp 클릭 시 나오는 기본 페이지
    @RequestMapping("") // 127.0.0.1/jsp
    public String main(Model model){
        model.addAttribute("center", dir + "center");
        model.addAttribute("leftNav", dir + "leftNav");
        return "index";
    }
    // jsp - leftNav "jsp01" 클릭 시 나오는 center 페이지
    @RequestMapping("/jsp01") // 127.0.0.1/jsp/jsp01
    public String jsp01(Model model){
        model.addAttribute("num", 1000.234);
        Cust cust= new Cust("id01","pwd01","미니"); //dto에 정보 넣기
        model.addAttribute("cust", cust); //db에 저장된 사용자 정보 보여주기
        Date date = new Date();
        model.addAttribute("cdate", date); //날짜 보여주기. jsp 파일에서 사용할 때 cdate 라고 사용
        //
        model.addAttribute("center", dir + "jsp01"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    // jsp - leftNav "jsp02" 클릭 시 나오는 center 페이지
    @RequestMapping("/jsp02") // 127.0.0.1/jsp/jsp01
    public String jsp02(Model model){
        Cust cust= new Cust("id01","pwd01","미니"); //dto에 정보 넣기
        model.addAttribute("rcust", cust); //db에 저장된 사용자 정보 보여주기
        model.addAttribute("num", 1);

        model.addAttribute("center", dir + "jsp02"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    @RequestMapping("/jsp03") // 127.0.0.1/jsp/jsp03
    public String jsp03(Model model){
        //
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01","pwd01","미니")); //dto에 정보 넣기
        list.add(new Cust("id02","pwd02","망고"));
        list.add(new Cust("id03","pwd03","넛지"));
        list.add(new Cust("id04","pwd04","사랑"));
        list.add(new Cust("id05","pwd05","애플"));
        model.addAttribute("clist", list); // db에 저장된 list 보여주기(jsp파일에서 clist로 사용)
        
        
        model.addAttribute("center", dir + "jsp03"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }

    @RequestMapping("/jsp04") // 127.0.0.1/jsp/jsp04
    public String jsp04(Model model){
        model.addAttribute("center", dir + "jsp04"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    @RequestMapping("/jsp05") // 127.0.0.1/jsp/jsp05
    public String jsp05(Model model){
        model.addAttribute("center", dir + "jsp05"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }


}
