package com.kbstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    // 127.0.0.1
    @RequestMapping("/")
    public String main(){
        return "index";
    }
    // 로그인
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login"); // center에는 login페이지가 뿌려져라.
        return "index";
    }
    // 회원가입
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register"); // center에는 register페이지가 뿌려져라.
        return "index";
    }
    // /quics?page=bs01   - 읽는방법 : 명령어 ? 데이터
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }
}
