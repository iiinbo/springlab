package com.kbstar.service;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;

import java.util.List;

public class UserService implements MyService<String, UserDTO> { // 뼈대 : MyService(뱅킹가입)

    MyDao<String, UserDTO> dao; // MyDao 인터페이스에서 고유하게 가지고있는 기능도~ 쓸거다.
    
    public UserService(MyDao dao){
        this.dao = dao; // 어떤 DB도 붙을 수 있다.
    }
    

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
