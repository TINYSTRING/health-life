package com.stringtinyst.healthlife.service.impl;

import com.stringtinyst.healthlife.mapper.DietMapper;
import com.stringtinyst.healthlife.service.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietServiceImpl implements DietService {
    @Autowired
    private DietMapper dietMapper;
    

}
