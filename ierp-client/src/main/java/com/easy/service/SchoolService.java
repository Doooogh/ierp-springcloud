package com.easy.service;

import com.easy.commons.CommonResult;
import com.easy.entity.edu.School;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 15:05
 * @Version 1.0
 **/

@Component
@FeignClient(value = "IERP-TEST-SERVICE",fallback = FallbackSchoolService.class)
public interface SchoolService {

    @GetMapping("/school/list")
    CommonResult list();

    @GetMapping("/school/get/{id}")
    CommonResult get(@PathVariable("id")String id);

    @PostMapping(value = "/school/save")
    CommonResult save( School school);

    @DeleteMapping("/school/delete/{id}")
    CommonResult delete(@PathVariable("id") String id);

    @GetMapping("/school/testDuan/{id}")
    CommonResult testDuan(@PathVariable("id") Long id);


}
