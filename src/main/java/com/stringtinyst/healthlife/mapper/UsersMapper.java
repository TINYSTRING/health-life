package com.stringtinyst.healthlife.mapper;

import com.stringtinyst.healthlife.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Insert("INSERT INTO users (UserID, Email, PasswordHash,Nickname,Gender,DateOfBirth) VALUES (#{userID}, #{email}, #{passwordHash},#{nickname},#{gender},#{dateOfBirth})")
    int insertUser(User user);

    @Select("SELECT COUNT(*) FROM users WHERE Email = #{email}")
    int countByEmail(String email);

    @Select("SELECT * FROM users WHERE Email = #{email} AND PasswordHash = #{passwordHash}")
    User getByemailAndPassword(String email, String passwordHash);
}