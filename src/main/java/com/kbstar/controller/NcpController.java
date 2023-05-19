package com.kbstar.controller;

import com.kbstar.Util.CFRCelebrityUtil;
import com.kbstar.Util.CFRFaceUtil;
import com.kbstar.Util.FileUploadUtil;
import com.kbstar.dto.Ncp;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class NcpController {

   // String dir = "ajax/"; // 매번, chart 라는 폴더 경로를 붙이기 귀찮을 때.
    @Value("${uploadimgdir}")
    String imgpath; // 이미지파일이 저장된 경로
    @RequestMapping("/cfr1impl") // http://172.16.20.126/cfr1impl
    public String cfr1impl(Model model, Ncp ncp) throws ParseException { // ncp(DTO) : img 정보 가지고 있다.
        // 순서 : 1. img를 util 을 통해 저장 ->
        FileUploadUtil.saveFile(ncp.getImg(), imgpath); // get img , 저장 경로
        
        // 순서 : 2. ncp에 요청해서 저장한 정보는 다시 끄집어내기
        String imgname = ncp.getImg().getOriginalFilename(); // "ma.jpg" 라는 이름의 이미지 파일 가져올 때 사용하는 함수명
        JSONObject result = (JSONObject) CFRCelebrityUtil.getResult(imgpath, imgname); // Util을 활용해서, 최종 결과는 이미지 저장된 경로, 이름 가져오기.
        // result = 0-{ faces : 1-[  2-{   celebrity : {마동석}   }  ]    }
        //log.info( result.toJSONString() );

        //  faces : 1-[  2-{   celebrity : {마동석}   }  ]
        JSONArray faces = (JSONArray) result.get("faces"); // [    ]
        JSONObject obj = (JSONObject) faces.get(0); // {  }
        JSONObject celebrity = (JSONObject) obj.get("celebrity"); // celebrity : {}
        String value = (String) celebrity.get("value"); // 마동석


        // 순서 : 3. 결과를 받는다.
        model.addAttribute("result",value); // 가져온 최종결과(value)값 화면에 보여주기.
        model.addAttribute("center","cfr1"); // 보여지는 화면 : cfr1
        return "index";

    }
    @RequestMapping("/cfr2impl") // http://172.16.20.126/cfr2impl
    public String cfr2impl(Model model, Ncp ncp) throws ParseException {
        // 순서 : 1. img를 util 을 통해 저장 ->
        FileUploadUtil.saveFile(ncp.getImg(), imgpath); // get img , 저장 경로

        // 순서 : 2. ncp에 요청해서 저장한 정보는 다시 끄집어내기
        String imgname = ncp.getImg().getOriginalFilename(); // "ma.jpg" 라는 이름의 이미지 파일 가져올 때 사용하는 함수명
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname); // Util을 활용해서, 최종 결과는 이미지 저장된 경로, 이름 가져오기.
        // result = 0-{ faces : 1-[  2-{   emotion : {result} ...  }  ], info : {size : ...}   }
        // emotion gender pose age
//        String emotion_value = "";
//        String gender_value = "";
//        String pose_value = "";
//        String age_value = "";
        //  faces : 1-[  2-{   celebrity : {마동석}   }  ]
        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        String emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        String gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        String pose_value = (String) pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        String age_value = (String) age.get("value");

        // tip. result가 여러개일 때! map에 담기
        Map<String, String> map = new HashMap<>();
        // 하나씩 result 집어넣기.
        map.put("emotion", emotion_value);
        map.put("gender", gender_value);
        map.put("pose", pose_value);
        map.put("age", age_value);

        model.addAttribute("result",map); // tip. result가 여러개일 때 명칭 하나로 가능.

        model.addAttribute("result1",emotion_value); // 가져온 최종결과(value)값 화면에 보여주기.
        model.addAttribute("result2",gender_value);
        model.addAttribute("result3",pose_value);
        model.addAttribute("result4",age_value);

        model.addAttribute("center","cfr2"); // 보여지는 화면 : cfr2
        return "index";
    }

    @RequestMapping("/mycfr") // http://172.16.20.126/mycfr
    public String mycfr(Model model, String imgname) throws ParseException {


        // 순서 : 2. ncp에 요청해서 저장한 정보는 다시 끄집어내기
        //String imgname = ncp.getImg().getOriginalFilename(); // "ma.jpg" 라는 이름의 이미지 파일 가져올 때 사용하는 함수명
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname); // Util을 활용해서, 최종 결과는 이미지 저장된 경로, 이름 가져오기.
        // result = 0-{ faces : 1-[  2-{   emotion : {result} ...  }  ], info : {size : ...}   }
        // emotion gender pose age
//        String emotion_value = "";
//        String gender_value = "";
//        String pose_value = "";
//        String age_value = "";
        //  faces : 1-[  2-{   celebrity : {마동석}   }  ]
        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);

        JSONObject emotion = (JSONObject) obj.get("emotion");
        String emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject) obj.get("gender");
        String gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        String pose_value = (String) pose.get("value");

        JSONObject age = (JSONObject) obj.get("age");
        String age_value = (String) age.get("value");

        // tip. result가 여러개일 때! map에 담기
        Map<String, String> map = new HashMap<>();
        // 하나씩 result 집어넣기.
        map.put("emotion", emotion_value);
        map.put("gender", gender_value);
        map.put("pose", pose_value);
        map.put("age", age_value);

        model.addAttribute("result",map); // tip. result가 여러개일 때 명칭 하나로 가능.

        model.addAttribute("center","pic"); // 보여지는 화면 : pic
        return "index";
    }

}
