package com.kbstar.dto;

import lombok.*;

// Lombok 기능덕에 : @키워드를 사용해서, 아규먼트 등 자동 생성 !!! - 아래 주절주절 안적어도 된다.
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Markerdesc {
    // 속성값만 입력해도 가능.
    private int id; // 시퀀스
    private int marker_id; // 테이블 marker 의 k값을 fk로 가져옴.
    private String item; // 메뉴명
    private int price; // 메뉴가격
    private String imgname; // 사진

}
