package com.easy.controller;

import com.easy.commons.CommonResult;
import com.easy.entity.edu.School;
import com.easy.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 14:28
 * @Version 1.0
 **/
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;


    @GetMapping("/list")
    public CommonResult list(){
        return CommonResult.success(schoolService.list());
    }


    @PostMapping("/save")
    public CommonResult save(@RequestBody School school){
        schoolService.save(school);
        return CommonResult.success();
    }


    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") String id){
        return CommonResult.success( schoolService.get(id));
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id){
        schoolService.delete(id);
        return CommonResult.success();
    }




}
