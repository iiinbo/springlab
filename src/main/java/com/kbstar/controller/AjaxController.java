package com.kbstar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "ajax/"; // 매번, chart 라는 폴더 경로를 붙이기 귀찮을 때.

    @RequestMapping("") // 127.0.0.1/ajax
    public String main(Model model){

        model.addAttribute("center",dir + "center");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/ajax01") // 127.0.0.1/ajax01
    public String ajax01(Model model){

        model.addAttribute("center",dir + "ajax01");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/ajax02") // 127.0.0.1/ajax02
    public String ajax02(Model model){

        model.addAttribute("center",dir + "ajax02");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/ajax03") // 127.0.0.1/ajax03
    public String ajax03(Model model){

        model.addAttribute("center",dir + "ajax03");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/ajax04") // 127.0.0.1/ajax04
    public String ajax04(Model model){

        model.addAttribute("center",dir + "ajax04");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/ajax05") // 127.0.0.1/ajax05
    public String ajax05(Model model){
        model.addAttribute("center",dir + "ajax05");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";
    }


}
