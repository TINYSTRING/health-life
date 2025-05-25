package com.stringtinyst.healthlife.mapper;

import com.stringtinyst.healthlife.pojo.Body;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BodyMapper {
    /**
     * 根据用户ID查询身体信息
     * @param userID 用户ID
     * @return 身体信息
     */
    @Select("SELECT * FROM body WHERE UserID = #{userID}")
    Body getByUserID(String userID);

    @Insert("INSERT INTO body (UserID, HeightCM, WeightKG, RecordDate) VALUES  (#{userID}, #{heightCM}, #{weightKG}, #{recordDate})")
    void insertBody(Body body);
}
