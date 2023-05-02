package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    CustService service;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    // 127.0.0.1
    @RequestMapping("/")
    public String main(){
        return "index";


    }


    // 1- 로그인
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login"); // center에는 login페이지가 뿌려져라.
        return "index";
    }
    // 로그인 시도 > 로그인impl
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd){ // 서버로 넘긴 정보 id, pwd
        logger.info(id +""+ pwd);
        model.addAttribute("center", "login"); // center에는 login페이지가 뿌려져라.
        return "index";
    }
    // 2- 회원가입
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register"); // center에는 register페이지가 뿌려져라.
        return "index";
    }
    // 회원가입 > 회원가입impl
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Cust cust) throws Exception { //사용자 전체정보가 필요한 경우 : CustDTO 이용해보기.
        // 가입완료 정보를 DB에 저장하기
        try {
            service.register(cust);
        } catch (Exception e) {
            throw new Exception("회원가입에 실패했습니다. ER0005");
        }

        model.addAttribute("rcust",cust);
        //custDTO정보를 rcust 에 담아서, 화면에 뿌릴 때 사용하기(사용법 : ${rcust.name}. key값(rcust), val값(custDTO)
        model.addAttribute("center", "registerok"); // center에는 register페이지가 뿌려져라.
        return "index"; // 해석 : index 파일 가운데 부분에 registerok 부분을 넣어서 화면을 만들어라.
    }
    // /quics?page=bs01   - 읽는방법 : 명령어 ? 데이터
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }
}
