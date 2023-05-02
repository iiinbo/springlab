package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService service;
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
    public String all(Model model) throws Exception {
        List<Item> list = new ArrayList<>();
        try {
            list = service.get();
        } catch (Exception e) {
            throw new Exception("시스템 장애 : ER0002");
        }

        model.addAttribute("allitem", list);

        model.addAttribute("center", dir + "all"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }


}
