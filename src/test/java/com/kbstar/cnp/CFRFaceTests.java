package com.kbstar.cnp;

import com.kbstar.Util.CFRCelebrityUtil;
import com.kbstar.Util.CFRFaceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CFRFaceTests {

    @Value("${uploadimgdir}") // 실제로! 이미지가 있는 장소
    String imgpath;

    @Autowired
    CFRFaceUtil cfrFaceUtil;

    @Test
    void contextLoads() throws ParseException {
       String imgname = "inbo.jpg"; // "ma.jpg" 라는 이름의 이미지 파일 가져오기.
        JSONObject result = (JSONObject) cfrFaceUtil.getResult(imgpath, imgname); // Util을 활용해서, 최종 결과는 이미지 저장된 경로, 이름 가져오기.
        log.info( result.toJSONString() );
    }

}
