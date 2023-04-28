package com.kbstar.dto;

import lombok.*;

import java.util.Date;

// Lombok 기능덕에 : @키워드를 사용해서, 아규먼트 등 자동 생성 !!! - 아래 주절주절 안적어도 된다.
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    // 속성값만 입력해도 가능.
    private int id; //상품관리번호 자동으로 채번되게 하려면 int(오라클 : 시퀀스) & xml 작성 유의
    private String name;
    private int price;
    private String imgname;
    private Date rdate; // 상품 등록일자

}
