package com.kbstar;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class Web13ApplicationTests {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        String rawPassword = "pwd01";
        String encPassword = encoder.encode(rawPassword); /*이 코드는 상위 줄의 패스워드를 암호화 시키는 코드이다*/
        log.info("------------------------------------------------------------------------------------");
        log.info(rawPassword);
        log.info("암호화 된 비번" + encPassword);
        boolean result = encoder.matches(rawPassword,encPassword);
        log.info(result+"");
    }
}
