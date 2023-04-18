package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("umdao")
public class UserMysqlDAO implements MyDao<String, UserDTO> {

    @Override
    public void insert(UserDTO userDTO) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void update(UserDTO userDTO) {

    }

    @Override
    public UserDTO select(String s) {
        return null;
    }

    @Override
    public List<UserDTO> select() {
        return null;
    }
}
