package com.easy.ierptest.service.impl;

import com.easy.ierptest.dao.SchoolDao;
import com.easy.common.entity.edu.School;
import com.easy.ierptest.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 14:27
 * @Version 1.0
 **/
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public List<School> list() {
        return schoolDao.list();
    }

    @Override
    public int save(School school) {
        return schoolDao.save(school);
    }

    @Override
    public School get(String id) {
        return schoolDao.get(id);
    }

    @Override
    public int delete(String id) {
        return schoolDao.delete(id);
    }


}
