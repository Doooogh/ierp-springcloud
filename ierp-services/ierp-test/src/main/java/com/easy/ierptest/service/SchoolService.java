package com.easy.ierptest.service;

import com.easy.common.entity.edu.School;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 14:26
 * @Version 1.0
 **/
public interface SchoolService {
    List<School> list();

    int save (School school);

    School get(String id);

    int delete(String id);
}
