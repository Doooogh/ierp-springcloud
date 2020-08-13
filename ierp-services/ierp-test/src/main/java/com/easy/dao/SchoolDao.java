package com.easy.dao;

import com.easy.entity.edu.School;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 14:24
 * @Version 1.0
 **/
public interface SchoolDao {
    List<School> list();
    int save (School school);
    School get(Integer id);

}
