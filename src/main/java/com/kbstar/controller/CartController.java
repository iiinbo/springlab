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

import javax.servlet.http.HttpSession;
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
    @RequestMapping("/all") // 127.0.0.1/cart/all?id=${logincust.id}
    // 로그인 한 고객(특정id)이 담은 카트바구니만 가져오기
    public String all(Model model, String id) throws Exception {
        List<Cart> list = null; // 카트에 담긴 상품내역 전체 담는 바구니 준비.
        try {
            list = service.getmycart( id ); // 카트 정보를 list에 담기. cid : cust_id
        } catch (Exception e) {
            throw new Exception(e);
        }

        model.addAttribute("mycart", list); // jsp에서 mycart로 꺼낼 예정
        model.addAttribute("center", dir + "center");
        return "index";
    }
    @RequestMapping("/delete") // 127.0.0.1/cart/delete?id=${logincust.id}
    // 로그인 한 고객(특정id)이 담은 카트바구니만 가져오기
    public String delete(Model model, Integer id, HttpSession session) throws Exception {

        try {
            service.remove( id );
            if(session != null){ // ses 정보 남아있어야 삭제 완료 > 본페이지 이동
                Cust cust = (Cust) session.getAttribute("logincust");
                return "redirect:/cart/all?id="+cust.getId(); // 특정 회원의 장바구니 전체조회 페이지로 회귀하기.
                                        // delete 버튼을 눌렀을 때 넘어가는 <a>링크와는 전혀 관계없다.
                                        // 아이템이 삭제는 완료되었는데, 에러창이 보인다면,
                                        //  return 경로만 문제이며, 여기서 적혀있는 cid는
                                        // cid : DB에 이미 저장되어있는 cust(회원)의 id.
            }else{
                return "redirect:/"; // ses 정보 사라지면 > 홈으로 이동
            }
        } catch (Exception e) {
            throw new Exception("장애발생");
        }

    }




}
