package com.stringtinyst.healthlife.service.impl;

import com.stringtinyst.healthlife.mapper.BodyMapper;
import com.stringtinyst.healthlife.pojo.Body;
import com.stringtinyst.healthlife.service.BodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BodyServiceImpl implements BodyService {
    @Autowired
    private BodyMapper bodyMapper;
    @Override
    public Body getByUserID(String userID) {
        return bodyMapper.getByUserID(userID);
    }

    @Override
    public void addBody(Body body) {
        body.setRecordDate(LocalDate.now());
        bodyMapper.insertBody(body);
    }
}
