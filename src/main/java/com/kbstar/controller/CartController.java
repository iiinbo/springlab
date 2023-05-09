package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.service.CartService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Slf4j //log 출력가능하게 도와줌. 밑에 안써도 됨.
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService service;

    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "cart/"; // 매번, cart 라는 폴더 경로를 붙이기 귀찮을 때.


    @RequestMapping("") // 127.0.0.1/cart
    // cart 클릭 시 나오는 기본 페이지
    public String main(Model model) throws Exception {
        return "index";
    }

    // 상단 - 로그인고객이 cart 클릭 시 (카트 담긴 상품의 전체조회와 동일.)
    @RequestMapping("all") // 127.0.0.1/cart/all?id=${logincust.id}
    // 로그인 한 고객(특정id)이 담은 카트바구니만 가져오기
    public String main(Model model, String cid) throws Exception {
        List<Cart> list = null; // 카트에 담긴 상품내역 전체 담는 바구니 준비.
        try {
            list = service.getmycart( cid ); // 카트 정보를 list에 담기.
        } catch (Exception e) {
            throw new Exception(e);
        }

        model.addAttribute("mycart", list); // jsp에서 mycart로 꺼낼 예정
        model.addAttribute("center", dir + "center");
        return "index";
    }

    // cust - leftNav "add" 클릭 시 나오는 center 페이지
//    @RequestMapping("/add") // 127.0.0.1/cust/add
//    public String add(Model model){
//        model.addAttribute("center", dir + "add"); // center만 변경
//        model.addAttribute("leftNav", dir + "leftNav"); // leftNav 그대로
//        return "index";
//    }



}
