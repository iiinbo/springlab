package com.kbstar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "map/"; // 매번, map 라는 폴더 경로를 붙이기 귀찮을 때.

    @RequestMapping("") // 127.0.0.1/map
    public String main(Model model){

        model.addAttribute("center",dir + "center");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/map01") // 127.0.0.1/map01
    public String map01(Model model){

        model.addAttribute("center",dir + "map01");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/map02") // 127.0.0.1/map02
    public String map02(Model model){

        model.addAttribute("center",dir + "map02");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/map03") // 127.0.0.1/map03
    public String map03(Model model){

        model.addAttribute("center",dir + "map03");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/map04") // 127.0.0.1/map04
    public String map04(Model model){

        model.addAttribute("center",dir + "map04");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    @RequestMapping("/map05") // 127.0.0.1/map05
    public String map05(Model model){
        model.addAttribute("center",dir + "map05");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";
    }


}
