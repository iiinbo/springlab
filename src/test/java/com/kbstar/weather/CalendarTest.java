package com.kbstar.weather;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Calendar;

@Slf4j
@SpringBootTest
class CalendarTest {


    @Test
    void contextLoads() {
       Calendar c = Calendar.getInstance(); // 최신 Date 함수
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DATE);

        String month_str = month+""; // 정수 -> 문자로 변환
        if(month_str.length() == 1){
            month_str = "0"+month_str; // month_str = 0 + 문자
        }

        String today = ""+year+month_str+day+"0600"; // 년월일 + 아침 6시 로 출력
        log.info(today); // 출력 : 202305100600
    }

}
