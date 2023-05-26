package com.kbstar;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class Web23ApplicationTests {
    @Autowired
    private BCryptPasswordEncoder encoder; // 패스워드를 암호화 해주는 함수

    @Test
    void contextLoads() {
        String rawPassword = "pwd01";
        String encPassword = encoder.encode(rawPassword);
        log.info("====================");
        log.info(rawPassword); // pwd01 찍어보고
        log.info("암호화 된 비번" + encPassword); // 암호화된 문자도 찍어보기.
        // ** 암호화한 비밀번호와, 원래 비번을 비교 ** 일치여부 확인해보기.
        boolean result = encoder.matches("pwd01",encPassword);
        log.info(result+""); // true, false
    }

}
