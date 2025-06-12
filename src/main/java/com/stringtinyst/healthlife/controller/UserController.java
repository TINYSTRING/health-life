package com.stringtinyst.healthlife.controller;

import com.stringtinyst.healthlife.pojo.Result;
import com.stringtinyst.healthlife.pojo.User;
import com.stringtinyst.healthlife.service.UserService;
import com.stringtinyst.healthlife.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService  userService;

    // 用户注册
    @PostMapping("/register")
    public Result registerUser(@RequestBody User user) {
        user.setUserID(UUID.randomUUID().toString());
        boolean flag = userService.registerUser(user);

        if (!flag) {
            //如果注册失败，返回错误信息
            log.error("用户注册失败");
            return Result.error("用户注册失败,已有相同邮箱");
        }
        //如果注册成功，返回成功信息
        log.info("用户注册成功");
        return Result.success(user.getUserID());
    }
    @PostMapping("/login")
    public Result loginUser(@RequestBody User user) {
        String loginUser = userService.loginUser(user);
        log.info("尝试登录: email={}, passwordHash={}", user.getEmail(), user.getPasswordHash());
        if (loginUser == null) {
            log.error("用户登录失败");
            return Result.error("用户登录失败,邮箱或密码错误或从未注册");
        }
        log.info("用户登录成功");
        user.setUserID(loginUser);
        Map<String,Object> claims = new HashMap<>();
        claims.put("userID",user.getUserID());
        claims.put("email",user.getEmail());
        String token = JwtUtils.generateJwt(claims);
        return Result.success(token);
    }
    @GetMapping("/{userID}")
    public Result getUser(@PathVariable String userID) {
        User userInfo = userService.getUser(userID);
        if (userInfo == null) {
            log.error("用户不存在");
            return Result.error("用户不存在");
        }
        log.info("获取用户信息成功");
        return Result.success(userInfo);
    }
    @PutMapping("/{userID}")
    public Result updateUser(@RequestBody User user) {
        boolean flag = userService.updateUser(user);
        if (!flag) {
            log.error("用户更新失败: {}",user);
            return Result.error("用户更新失败");
        }
        log.info("用户更新成功");
        return Result.success(user);
    }

}
