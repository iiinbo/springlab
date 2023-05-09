package com.kbstar;

// 예외처리를 이 한 곳에서 처리하려고 생성했다.
// 파일위치 : 컨트롤러 폴더가 아닌, kbstar 밑으로.

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 스프링 컨테이너 위에서 동작하며,
public class CustomErrorController {
    @ExceptionHandler(Exception.class) // 익셉션 발생하면 아래가 작동된다.
    public String except(Exception e, Model model){
        model.addAttribute("msg",e.getMessage());
        model.addAttribute("center","error/error_page1"); // center는 에러 전용화면으로 바꿔줘
        return "index";
    }
}