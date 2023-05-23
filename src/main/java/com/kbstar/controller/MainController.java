package com.kbstar.controller;

import com.kbstar.Util.WeatherUtil;
import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class MainController {
    // 패스워드 암호화 하기.
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Value("${adminserver}")
    String adminServer; // 관리자용 서버의 ip주소 일일이 수정하기 귀찮으니까. http://
    @Autowired
    CustService service;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    // 127.0.0.1
    @RequestMapping("/")
    public String main(Model model) throws Exception{
//        String result = WeatherUtil.getWeather1("109");
//        model.addAttribute("weatherinfo", result); // jsp 파일에서 weatherinfo 로 사용
        return "index"; // 날씨정보는 center에 출력


    }


    // 1- 로그인
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login"); // center에는 login페이지가 뿌려져라.
        return "index";
    }
    // 로그인 시도 > 로그인impl
        // session 추가.
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd,
                            HttpSession session) throws Exception {
        logger.info("-----" + id+"이고, "+pwd + "-----");
        Cust cust = null;
        String nextPage = "loginfail";
        try {
            cust = service.get(id);
            // 로그인 성공 시
            if(cust != null && encoder.matches(pwd, cust.getPwd())){
                nextPage = "loginok";
                session.setMaxInactiveInterval(100000); // 세션 시간 지정
                session.setAttribute("logincust", cust);
            }
        } catch (Exception e){
            throw new Exception("시스템 장애. 잠시 후 다시 로그인 해주세요.");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }
    // 3- 로그아웃
        // session 추가.
    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session){
        if (session != null ) { // session에 정보가 비어있지 않다면,
            session.invalidate(); // 비워라.
        }
        //model.addAttribute("center", "logout"); // center에는 login페이지가 뿌려져라.
        return "index";
    }
    // 4. 로그인한 고객 '본인'이 나의 회원정보 상세보기
    @RequestMapping("/custinfo")
    public String custinfo(Model model, String id) throws Exception {
        Cust cust = null; // 받을 준비.
        try {
            cust = service.get( id );
        } catch (Exception e) {
            throw new Exception("본인의 정보 상세보기 중 에러발생 ER0007");
        }
        model.addAttribute("custinfo", cust); // cust에 담겨있던 id를 custinfo 페이지로 넘겨주기
        model.addAttribute("center", "custinfo"); // center에는 custinfo페이지가 뿌려져라.
        return "index";
    }
    // 4-2. 본인의 회원정보 수정하기
    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model, Cust cust) throws Exception {

        try {
            log.info("-----------", cust.getPwd() );
            // 1- 수정 전! pwd만 암호화하기.
            cust.setPwd(encoder.encode( cust.getPwd() ));
            // 2- 수정받은 고객정보 id, pwd, name 모두 수정.
            service.modify( cust );
        } catch (Exception e) {
            throw new Exception("본인의 회원정보 수정 중 에러발생 ER0008");
        }
        // model 말고, redirect 사용해서 다시 위치해있던 custinfo 페이지 + 해당고객의 페이지(id)로 가기.
        return "redirect:/custinfo?id=" + cust.getId();
    }
    // 5. 회원가입
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register"); // center에는 register페이지가 뿌려져라.
        return "index";
    }
    // 회원가입 > 회원가입impl
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Cust cust, HttpSession session) throws Exception { //사용자 전체정보가 필요한 경우 : CustDTO 이용해보기.
        // 가입완료 정보를 DB에 저장하기
        try {
            cust.setPwd(encoder.encode( cust.getPwd() ));
            //위 코드 설명 . 고객이 입력한 패스워드 -> 가져와서 암호화한 뒤 다시 cust객체로 넣어 db에 집어넣는다.
            service.register(cust);
            // 가입완료 즉시, 로그인까지 바로 되게 하기
            session.setAttribute("logincust", cust);
        } catch (Exception e) {
            throw new Exception("회원가입에 실패했습니다. ER0005");
        }

        model.addAttribute("rcust",cust);
        //custDTO정보를 rcust 에 담아서, 화면에 뿌릴 때 사용하기(사용법 : ${rcust.name}. key값(rcust), val값(custDTO)
        model.addAttribute("center", "registerok"); // center에는 register페이지가 뿌려져라.
        return "index"; // 해석 : index 파일 가운데 부분에 registerok 부분을 넣어서 화면을 만들어라.
    }
    // /quics?page=bs01   - 읽는방법 : 명령어 ? 데이터
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }

    // left바 첫번째 링크 : pic
    @RequestMapping("/pic")
    public String pic(Model model) {
        model.addAttribute("center", "pic"); //pic페이지 이동
        return "index";
    }
    // left바 - websocket 링크연동 탭
    // 참고 : 세부 동작들은 (ex. receiveall) admin화면에 msg컨트롤러에서 처리한다.(컨트롤러에선, send로 메세지 뿌리기)
    @RequestMapping("/websocket")
    public String websocket(Model model) {
        model.addAttribute("adminServer", adminServer); // 서버주소 jsp에서 치기 간편
        model.addAttribute("center", "websocket"); //websocket페이지로 교체
        return "index";
    }

    // 6. cfr1
    @RequestMapping("/cfr1")
    public String cfr1(Model model) {

        model.addAttribute("center", "cfr1"); //cfr1페이지로 교체
        return "index";
    }
    // 6. cfr2
    @RequestMapping("/cfr2")
    public String cfr2(Model model) {

        model.addAttribute("center", "cfr2"); //cfr2페이지로 교체
        return "index";
    }

    // 참고 : 세부 동작들은 (ex. receiveall) admin화면에 msg컨트롤러에서 처리한다.(컨트롤러에선, send로 메세지 뿌리기)
    @RequestMapping("/chatbot")
    public String chatbot(Model model, HttpSession session) {
        if (session.getAttribute("logincust") == null ){
            return "redirect:/login"; // 로그인 후 챗봇 이용할 수 있게 페이지 권유.
        }
        model.addAttribute("adminServer", adminServer); // 서버주소를 jsp에서 치기 간편하게.
        model.addAttribute("center", "chatbot"); //chatbot 페이지 교체
        return "index";
    }
    @RequestMapping("/callcenter")
    public String callcenter(Model model, HttpSession session) {
        if (session.getAttribute("logincust") == null ){
            return "redirect:/login"; // 로그인 후 콜센터 이용할 수 있게 페이지 권유.
        }
        model.addAttribute("adminServer", adminServer); // 서버주소 jsp에서 치기 간편하게.
        model.addAttribute("center", "callcenter"); //chatbot 페이지 교체
        return "index";
    }
}
