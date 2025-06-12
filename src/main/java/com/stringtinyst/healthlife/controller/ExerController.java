package com.stringtinyst.healthlife.controller;

import com.stringtinyst.healthlife.pojo.PageBean;
import com.stringtinyst.healthlife.pojo.Result;
import com.stringtinyst.healthlife.service.ExerService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.stringtinyst.healthlife.pojo.Exer;

import java.time.LocalDate;

@RestController
@RequestMapping("/exerciseItems")
public class ExerController {
    @Autowired
    private ExerService exerService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       @RequestParam String userID,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                       String exerciseType) {
        PageBean pageBean = exerService.page(page, pageSize, userID,startDate, endDate, exerciseType);
        return Result.success(pageBean);
    }
    @GetMapping("/{exerciseItemID}")
    public Result Exerlist(@PathVariable int exerciseItemID) {
        Exer exer = exerService.getByExerItemID(exerciseItemID);
        return Result.success(exer);
    }
    @PostMapping
    public Result addExer(@RequestBody Exer exer) {
        exerService.addExer(exer);
        int exerItemID = exerService.searchExerItemID(exer);
        return Result.success(exerItemID);
    }
    @PutMapping("/{exerciseItemID}")
    public Result updateExer(@PathVariable int exerciseItemID, @RequestBody Exer exer) {
        exer.setExerciseItemID(exerciseItemID);
        exerService.updateExer(exer);
        return Result.success();
    }
    @Delete("/{exerciseItemID}")
    public Result deleteExer(@PathVariable int exerciseItemID) {
        exerService.deleteExer(exerciseItemID);
        return Result.success();
    }


}
