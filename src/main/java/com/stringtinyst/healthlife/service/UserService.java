package com.stringtinyst.healthlife.service;

import com.stringtinyst.healthlife.pojo.User;

public interface UserService {
    boolean registerUser(User user);

    User loginUser(User user);
}
