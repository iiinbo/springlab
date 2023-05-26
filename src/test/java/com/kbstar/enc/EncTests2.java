package com.kbstar.enc;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class EncTests2 {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("mykey"); // key값(패스워드)이 있어야 암호화 작업공간에 들어갈 수 있음

        String phone = "01022225555";
        String addr = "서울 성수동 222-5";

        // 암호화 해보기
        String encphone = pbeEnc.encrypt(phone); // encrypt : 암호화 해주는 기능으로 1차 암호화.
        log.info("=================================="+encphone);
        String encaddr = pbeEnc.encrypt(addr); // encrypt : 암호화 해주는 기능
        log.info("=================================="+encaddr);

        phone = pbeEnc.decrypt(encphone); // 다시 암호화
        addr = pbeEnc.decrypt(encaddr);
        log.info("==================================phone : "+phone);
        log.info("==================================addr : "+addr);

//
//        String url = "jdbc:mysql://localhost:3306/toma";
//        String cfr_id = "nv41tzmjwg";
//        String cfr_key = "TphoNoEwkohejt9FejMArjZmXi7uvIyRMS5lreJP";
//        String enc_cfr_id = pbeEnc.encrypt(cfr_id);
//        System.out.println("기존  URL :: " + url + " | 변경 URL :: " + pbeEnc.encrypt(url));
//        System.out.println("기존  cfr_id :: " + cfr_id + " | 변경 username :: " + enc_cfr_id);
//        System.out.println("기존  cfr_key :: " + cfr_key + " | 변경 password :: " + pbeEnc.encrypt(cfr_key));
//
//        System.out.println(pbeEnc.decrypt("KQce/eAYu0kaEv1Lopuz5l/KUhEZQTwL"));

    }

}