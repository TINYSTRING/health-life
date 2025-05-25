package com.stringtinyst.healthlife.service;

import com.stringtinyst.healthlife.pojo.Body;
import org.springframework.stereotype.Service;


public interface BodyService {
    Body getByUserID(String userID);

    void addBody(Body body);
}
