package com.kbstar.weather;

import com.kbstar.Util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;


@Slf4j
@SpringBootTest
class WeatherTest {
    // 날씨 테스트 하기 5.10
    // 1- 기상청에서 제공하는 json data가 나에게로 오는지부터 테스트하기.(test폴더 - weatherTest 파일)
    @Test
    void contextLoads() throws Exception {
        JSONObject result = null;
        result = (JSONObject)WeatherUtil.getWeather3("108"); // 서울지역 날씨가져오기


        log.info(result.toJSONString());

    }

}
