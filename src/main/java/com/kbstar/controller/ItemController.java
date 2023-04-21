package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "item/"; // 매번, item 라는 폴더 경로를 붙이기 귀찮을 때.

    // 상단 - item 클릭 시 나오는 기본 페이지
    @RequestMapping("") // 127.0.0.1/item
    public String main(Model model){
        model.addAttribute("center", dir + "center");
        model.addAttribute("leftNav", dir + "leftNav");
        return "index";
    }
    // item - leftNav "add" 클릭 시 나오는 center 페이지
    @RequestMapping("/add") // 127.0.0.1/item/add
    public String add(Model model){
        model.addAttribute("center", dir + "add"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    // item - leftNav "all" 클릭 시 나오는 center 페이지
    @RequestMapping("/all") // 127.0.0.1/item/all
    public String all(Model model){
        List<Item> list = new ArrayList<>();
        list.add(new Item(100,"브레드사장님",1000,"a.jpg", new Date() )); //db에는 이미지 이름만 들어감.
        list.add(new Item(101,"캐셔초코",2000,"b.jpg", new Date() ));
        list.add(new Item(102,"매니저밀크",3000,"c.jpg", new Date() ));
        list.add(new Item(103,"반려소세지",4000,"d.jpg", new Date() ));
        list.add(new Item(104,"악당감자칩",5000,"e.jpg", new Date() ));
        model.addAttribute("allitem", list);


        model.addAttribute("center", dir + "all"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }


}
