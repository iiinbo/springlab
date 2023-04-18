package com.kbstar.service;

import com.kbstar.dao.OracleDao;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;

import java.util.List;

public class BankingService implements MyService<String, UserDTO> {

    MyDao<String, UserDTO> dao; // 인터페이스 객체인 MyDao는 선언 즉시 사용어려워서 아래처럼 public으로 적은 뒤 쓰기
    public BankingService(){
        dao = new OracleDao();
    }
    @Override
    public void register(UserDTO userDTO) {

        dao.insert(userDTO);
        System.out.println("send Email");
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public UserDTO get(String s) {

        return null;
    }

    @Override
    public List<UserDTO> get() {
        return null;
    }

}
