package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    CustService service;

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

    public String all(Model model) throws Exception {
        // 상세설명 : List<Cust> list = null ; 담기위해 바구니를 준비한다는 의미

        // 선생님 방법 : public 옆에 throws Exception 안 붙이고, 아래처럼 쓴 뒤
        // get 함수에 빨간색 누르면 try-catch 문으로 나온다. 예외처리 가능~
        List<Cust> list = null;
        try {
            list = service.get();
        } catch (Exception e) {
            throw new Exception("시스템 장애 발생 : ER0001");
        }

        model.addAttribute("clist", list); // db에 저장된 list 보여주기(jsp파일에서 clist로 사용)
        model.addAttribute("center", dir + "all"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    // get
    @RequestMapping("/get") // 127.0.0.1/cust/get?id=
    public String get(Model model, String id) throws Exception{
        //db에서 요청하는 id에 대한 정보를 가져오기.

        // test파일에선 : service.get( "id01" );

        Cust cust = service.get( id );
        model.addAttribute("gcust", cust);
        model.addAttribute("center", dir + "get"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }

}
