package com.easy.client.service;

import com.easy.common.commons.CommonResult;
import com.easy.common.entity.edu.School;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/18 16:30
 * @Version 1.0
 **/
@Service
public class FallbackSchoolService implements SchoolService{
    @Override
    public CommonResult list() {
        return CommonResult.errorOfMessage("get schoolList  error!!!");
    }

    @Override
    public CommonResult get(String id) {
        return CommonResult.errorOfMessage("get school error!!!");
    }

    @Override
    public CommonResult save(School school) {
        return CommonResult.errorOfMessage("save school error!!!");
    }

    @Override
    public CommonResult delete(String id) {
        return CommonResult.errorOfMessage("delete school error!!!");

    }

    @Override
    public CommonResult testDuan(Long id) {
        return null;
    }
}
