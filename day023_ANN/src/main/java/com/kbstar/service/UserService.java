package com.kbstar.service;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
// 1. ann방식 : 어노테이션 추가(이름붙이기) - 나중에 찾기위해
@Service("uservice")
public class UserService implements MyService<String, UserDTO> { // 뼈대 : MyService(뱅킹가입)
    @Autowired // 2. 어노테이션 추가
    @Qualifier("udao")
    MyDao<String, UserDTO> dao; // MyDao 인터페이스에서 고유하게 가지고있는 기능도~ 쓸거다
    // UserDAO dao; // 다른 db안쓴다고 하면, 하나로 표현도 가능.
    @Override
    public void register(UserDTO userDTO) { // 뼈대 : MyService 뱅킹가입을 위해
        dao.insert(userDTO); // 기능 얻어오기 : MyDao에서 가지고 있는 기능인 insert를 활용하기
        System.out.println("회원가입에 성공했다고 이메일 발송 완료");
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
    }

    @Override
    public void modify(UserDTO userDTO) {
        dao.update(userDTO);
        System.out.println("정보 수정이 완료되었다고 이메일 발송 완료");

    }

    @Override
    public UserDTO get(String s) {
        return dao.select(s);
    }

    @Override
    public List<UserDTO> get() {
        return dao.select();
    }
}
