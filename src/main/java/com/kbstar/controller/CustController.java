package com.kbstar.controller;

import com.kbstar.dto.Cust;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j //log 출력가능하게 도와줌. 밑에 안써도 됨.
@Controller
@RequestMapping("/cust")
public class CustController {
    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "cust/"; // 매번, cust 라는 폴더 경로를 붙이기 귀찮을 때.

    // 상단 - cust 클릭 시 나오는 기본 페이지
    @RequestMapping("") // 127.0.0.1/cust
    public String main(Model model){
        model.addAttribute("center", dir + "center");
        model.addAttribute("leftNav", dir + "leftNav");

        Random r = new Random();
        int inx = r.nextInt(1000)+1;
        log.info(inx+""); // @선언하고 좌측처럼 적으면 log에 시간과 메세지 찍힌다.
        return "index";
    }
    // cust - leftNav "add" 클릭 시 나오는 center 페이지
    @RequestMapping("/add") // 127.0.0.1/cust/add
    public String add(Model model){
        model.addAttribute("center", dir + "add"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    // cust - leftNav "all" 클릭 시 나오는 center 페이지
    @RequestMapping("/all") // 127.0.0.1/cust/all
    public String all(Model model){
        //
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01","pwd01","미니")); //dto에 정보 넣기
        list.add(new Cust("id02","pwd02","망고"));
        list.add(new Cust("id03","pwd03","넛지"));
        list.add(new Cust("id04","pwd04","사랑"));
        list.add(new Cust("id05","pwd05","애플"));

        model.addAttribute("clist", list); // db에 저장된 list 보여주기(jsp파일에서 clist로 사용)


        model.addAttribute("center", dir + "all"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    // get
    @RequestMapping("/get") // 127.0.0.1/cust/get?id=
    public String get(Model model, String id){
        //db에서 요청하는 id에 대한 정보를 가져오기.
        Cust cust = new Cust(id,"xxx","미니");
        model.addAttribute("gcust", cust);

        model.addAttribute("center", dir + "get"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }

}
