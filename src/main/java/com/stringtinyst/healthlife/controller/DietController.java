package com.stringtinyst.healthlife.controller;

import com.stringtinyst.healthlife.service.DietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DietController {
    @Autowired
    private DietService dietService;


}
