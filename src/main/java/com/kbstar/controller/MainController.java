package com.kbstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    // http://127.0.0.1/ 호출을 의미함
    @RequestMapping("/")
    public String main(){
        return "index"; // 동일한 파일명 찾기
    }
    // "/next"를 요청
    @RequestMapping("/next")
    public String next(){
        return "next"; // 동일한 파일명 찾기
    }
}
