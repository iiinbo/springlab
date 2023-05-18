package com.kbstar.dto;

import lombok.*;

// Lombok 기능덕에 : @키워드를 사용해서, 아규먼트 등 자동 생성 !!! - 아래 주절주절 안적어도 된다.
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Adm {
    // 속성값만 입력해도 가능.
    private String id; // 어드민 사용할 수 있는 자의 아이디.(직접정함)
    private String pwd;
    private int lev; // 접속권한(레벨부여)

}
