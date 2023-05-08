package com.kbstar.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;

public class FileUploadUtil {
	public static void saveFile(MultipartFile mf, String dir) { // 파일덩어리, 디렉토리정보 주면
		// 아래에서 알아서 저장해줄게. 라는 의미의 함수.
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(dir+imgname);
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			e.printStackTrace(); // 에러 발생 시 상세문구 보여줘
		}
		
	}
	
}




