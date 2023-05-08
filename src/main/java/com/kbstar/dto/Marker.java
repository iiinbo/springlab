package com.kbstar.dto;

import lombok.*;

// Lombok 기능덕에 : @키워드를 사용해서, 아규먼트 등 자동 생성 !!! - 아래 주절주절 안적어도 된다.
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Marker {
    // 속성값만 입력해도 가능.
    private int id;
    private String title;
    private String target;
    private double lat;
    private double lng;
    private String img;
    private String loc;
}
