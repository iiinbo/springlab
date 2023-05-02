package com.kbstar.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Cart {
    private int id;
    private String cust_id;
    private int item_id;
    private int cnt;
    private Date rdate;

    // insert용 컨스트럭터 만들어보기 : id는 시퀀스. 아래 3개 값 넣으면 자동생성
    public Cart(String cust_id, int item_id, int cnt) {
        this.cust_id = cust_id;
        this.item_id = item_id;
        this.cnt = cnt;
    }
    // update용 컨스트럭터 만들어보기
    public Cart(int id, String cust_id, int item_id, int cnt) {
        this.id = id;
        this.cust_id = cust_id;
        this.item_id = item_id;
        this.cnt = cnt;
    }

    // select할 때 사용 : 오라클에서 AS 로 칼럼 별칭 정한 이름과 똑같이!
    private String cust_name;
    private String item_name;
    private int item_price;
    private String item_imgname;

}
