package com.kbstar.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService service;

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
        List<Item> list = null;
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

    //3-1. item - leftNav "allpage" 클릭 시 나오는 center 페이지
    @RequestMapping("/allpage") // 127.0.0.1/item/allpage
    public String allpage(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) throws Exception {
        PageInfo<Item> p;
        try {
            p = new PageInfo<>(service.getpage(pageNo), 5); // 5:하단 네비게이션 개수(화살표 사이 넘버개수)
        } catch (Exception e) {
            throw new Exception("시스템 장애 : ER0002");
        }
        model.addAttribute("target", "item"); // 공통사용하기로 한 page.jsp이용
        model.addAttribute("cpage", p); // 넣어주기

        model.addAttribute("center", dir + "allpage"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }
    // 3-2. item 상품정보 상세보기
    @RequestMapping("/get") // 127.0.0.1/item/get?id=
    public String get(Model model, Integer id) throws Exception{
        //db에서 요청하는 id에 대한 정보를 가져오기.

        Item item = service.get( id );
        model.addAttribute("gitem", item);
        model.addAttribute("center", dir + "get"); // center만 변경
        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
        return "index";
    }

}
