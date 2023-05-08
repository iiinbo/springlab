package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.CartService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item") // /cust를 넣음으으로 기본적으로 주소에 /cust가 셋팅됨
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    CartService cartService;
    String dir = "item/"; //폴더명을 변수로 넣기

    //127.0.0.1/cust
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model,Integer id) throws Exception {
        Item item = null;
        item = itemService.get(id);
        model.addAttribute("gitem",item);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model) throws Exception {
        List<Item> list = null;
        try {
            list = itemService.get();
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }
        model.addAttribute("allitem",list);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"all");
        return "index";
    }

    @RequestMapping("/allpage")
    public String allpage(@RequestParam(required = false, defaultValue = "1") int pageNo,
                          Model model) throws Exception {
        PageInfo<Item> p;
        try {
            p = new PageInfo<>(itemService.getPage(pageNo), 5); // 5:하단 네비게이션 개수
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }
        model.addAttribute("target","item");
        model.addAttribute("cpage",p);

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"allpage");
        return "index";
    }

    //카트 조회 : 복습하기.
    @RequestMapping("/allcart")
    public String allcart(Model model, String id) throws Exception {
        List<Cart> list = null;
        try {
            list = cartService.getmycart(id); // 바구니에 Cart 정보 담기
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }
        model.addAttribute("allcart",list);
        model.addAttribute("center","cart"); // dir 필요없어
        return "index";
    }
    //카트 추가 : 복습
    @RequestMapping("/addcart")
    public String addcart(Model model, Cart cart) throws Exception {
        
        try {
             cartService.register(cart); // 카트 신규
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }
         // 추가한 뒤엔 로그인한 본인의 카트조회 페이지로.
        return "redirect:/item/allcart?id="+cart.getCust_id();
    }
    //카트 삭제 : 복습
    @RequestMapping("/delcart")
    public String delcart(Model model, Integer id,  HttpSession session) throws Exception {

        try {
           cartService.remove( id ); // 카트 테이블의 시퀀스로 지정된 id에 대한 것 삭제
            if(session != null){ // ses 정보 남아있어야 삭제 완료 > 본페이지 이동
                Cust cust = (Cust) session.getAttribute("logincust");
                return "redirect:/item/allcart?id="+cust.getId();
            }else{
                return "redirect:/"; // ses 정보 사라지면 > 홈으로 이동
            }
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER000222");
        }
    }

}
