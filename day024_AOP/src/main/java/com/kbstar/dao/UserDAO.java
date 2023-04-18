package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
// ann방식 : 어노테이션 추가
@Repository("udao")
public class UserDAO implements MyDao<String, UserDTO> {

    @Override
    public void insert(UserDTO userDTO) {
    System.out.println("Inserted Oracle" + userDTO);
    }

    @Override
    public void delete(String s) {
        System.out.println("Deleted Oracle " + s);
    }

    @Override
    public void update(UserDTO userDTO) {
        System.out.println("Updated Oracle " + userDTO);
    }

    @Override
    public UserDTO select(String s) {
        UserDTO user = null; // 조회항목 가져올 팀원 준비.
        user = new UserDTO(s, "pwd01", "newjeans");
        return user;
    }

    @Override
    public List<UserDTO> select() {
        List<UserDTO> list = new ArrayList<>(); // 가져올 바구니 준비
        list.add(new UserDTO("id01", "pwd01", "newjeans")); // 바구니에 넣기
        list.add(new UserDTO("id02", "pwd02", "newjeans2")); // 바구니에 넣기
        list.add(new UserDTO("id03", "pwd03", "newjeans3")); // 바구니에 넣기
        return list;
    }

}
