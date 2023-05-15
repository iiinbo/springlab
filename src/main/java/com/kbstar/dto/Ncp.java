package com.kbstar.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.format.annotation.DateTimeFormat;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Ncp {

    private MultipartFile img; // jsp파일. form 내용 중 서버로 전달할 정보 : img

}

