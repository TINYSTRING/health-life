package com.stringtinyst.healthlife.controller;

import com.stringtinyst.healthlife.pojo.Body;
import com.stringtinyst.healthlife.pojo.PageBean;
import com.stringtinyst.healthlife.pojo.Result;
import com.stringtinyst.healthlife.service.BodyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/bodyMetrics")

public class BodyController {

    @Autowired
    private BodyService bodyService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam String userID,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){
        log.info("分页查询 {},{},{},{}",page,pageSize,startDate,endDate);
        PageBean pageBean = bodyService.page(page, pageSize,userID,startDate,endDate);
        return Result.success(pageBean);
    }
    /**
     * 根据bodyMetricID查询身体数据
     * @param bodyMetricID
     * @return
     */
    @GetMapping("/{bodyMetricID}")
    public Result Bodylist(@PathVariable int bodyMetricID){
        log.info("查询身体数据");
        Body body = bodyService.getByBodyID(bodyMetricID);
        return Result.success(body);
    }
    /**
     * 添加身体数据
     * @param body
     * @return
     */
    @PostMapping
    public Result addBody(@RequestBody Body body){
        log.info("添加身体数据");
        bodyService.addBody(body);
        int bodyMetricID = bodyService.searchbodyID(body);
//        body.setBodyMetricID(bodyid);
        return Result.success(bodyMetricID);
    }
    /**
     * 更新身体数据
     * @param bodyMetricID
     * @param body
     * @return
     */
    @PutMapping("/{bodyMetricID}")
    public Result updateBody(@PathVariable int bodyMetricID, @RequestBody Body body){
        log.info("更新身体数据");
        body.setBodyMetricID(bodyMetricID);
        bodyService.updateBody(body);
        return Result.success();
    }
    @DeleteMapping("/{bodyMetricID}")
    public Result deleteBody(@PathVariable int bodyMetricID){
        log.info("删除身体数据");
        bodyService.deleteBody(bodyMetricID);
        return Result.success();
    }
}
