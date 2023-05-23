package com.kbstar.ncp;

import com.kbstar.Util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
class OCR2Tests {

    @Value("${uploadimgdir}") //이미지가 실제로! 있는장소(디렉토리)부터 선언
    String imgpath; // 경로

    @Test
    void contextLoads() throws ParseException {
        JSONObject jobj = null; // {} 출력할 준비.
        jobj = (JSONObject) OCRUtil.getResult( imgpath, "ocr.png");
       log.info( jobj.toJSONString() ); // {} 출력하기.

        Map map = OCRUtil.getOcr(jobj);
        log.info (map.values().toString() );
    }

}
