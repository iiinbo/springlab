package com.kbstar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "chart/"; // 매번, chart 라는 폴더 경로를 붙이기 귀찮을 때.

    @RequestMapping("") // 127.0.0.1/chart
    public String main(Model model){

        model.addAttribute("center",dir + "center");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/chart01") // 127.0.0.1/chart01
    public String chart01(Model model){

        model.addAttribute("center",dir + "chart01");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/chart02") // 127.0.0.1/chart02
    public String chart02(Model model){

        model.addAttribute("center",dir + "chart02");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/chart03") // 127.0.0.1/chart03
    public String chart03(Model model){

        model.addAttribute("center",dir + "chart03");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/chart04") // 127.0.0.1/chart04
    public String chart04(Model model){

        model.addAttribute("center",dir + "chart04");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/chart05") // 127.0.0.1/chart05
    public String chart05(Model model){
        model.addAttribute("center",dir + "chart05");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";
    }


}
