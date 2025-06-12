package com.stringtinyst.healthlife.service.impl;

import com.stringtinyst.healthlife.mapper.UsersMapper;
import com.stringtinyst.healthlife.pojo.User;
import com.stringtinyst.healthlife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper  usersMapper;

    @Override
    public boolean registerUser(User user) {
        // 检查 Email 是否已存在
        int count = usersMapper.countByEmail(user.getEmail());
        if (count > 0) {
            return false; // Email 已存在，返回 false
        }

        // 插入用户数据

        int result = usersMapper.insertUser(user);
        return result > 0; // 插入成功返回 true，否则返回 false
    }

    @Override
    public String loginUser(User user) {
        return usersMapper.getByemailAndPassword(user.getEmail(), user.getPasswordHash());
    }

    @Override
    public User getUser(String userID) {
        return usersMapper.getUser(userID);
    }

    @Override
    public boolean updateUser(User user) {
        return usersMapper.updateUser(user) > 0;
    }
}
