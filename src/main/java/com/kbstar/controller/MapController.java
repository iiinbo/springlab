package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.dto.Markerdesc;
import com.kbstar.service.MarkerDescService;
import com.kbstar.service.MarkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/map")
public class MapController {
    @Autowired
    MarkerService service;
    @Autowired
    MarkerDescService markerDescService;
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
    // marker : 맛집추천 지도
    @RequestMapping("/map03") // 127.0.0.1/map03
    public String map03(Model model) throws Exception{

        //List<Marker> list = service.get();

        model.addAttribute("center",dir + "map03");
        model.addAttribute("leftNav",dir + "leftNav");
        return "index";

    }
    // ** map03과 연결되는 marker 클릭 시 연동되는 url
    @RequestMapping("/detail") // 127.0.0.1/map/detail
    public String detail(Model model, int id) throws Exception {
        
        // marker 클릭 시 선택된 맛집id에 대한 정보 가져오기(상세정보 가져오기)
        Marker marker = null; // 준비
        List <Markerdesc> markerdesc = null; // 상세준비
        try {
            marker = service.get( id );
            markerdesc = markerDescService.getmarkerdesc( id );
        } catch (Exception e) {
            throw new Exception("상세 맛집정보 조회 중 에러 발생! ER0004");
        }
        model.addAttribute("gmarker",marker); // 정보 보여주기
        model.addAttribute("mlist",markerdesc); // 상세정보 보여주기
        
        model.addAttribute("center",dir + "detail"); // center를 detail페이지로 교체
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
