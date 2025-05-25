package com.stringtinyst.healthlife.controller;

import com.stringtinyst.healthlife.pojo.Body;
import com.stringtinyst.healthlife.pojo.Result;
import com.stringtinyst.healthlife.service.BodyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/bodyMetrics")

public class BodyController {

    @Autowired
    private BodyService bodyService;

    @GetMapping("/{userID}")
    public Result Bodylist(@PathVariable String userID){
        log.info("查询身体数据");
        Body body = bodyService.getByUserID(userID);
        return Result.success(body);
    }

    @PostMapping
    public Result addBody(@RequestBody Body body){
        log.info("添加身体数据");
        bodyService.addBody(body);
        return Result.success();
    }

}
