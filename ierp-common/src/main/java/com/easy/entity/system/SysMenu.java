package com.easy.entity.system;

import lombok.Data;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 15:05
 * @Version 1.0
 **/
@Data
public class SysMenu {

    private String id;
    private String parentId;
    private String title;
    private String name;
    private Integer sort;
    private String icon;
    private Integer hidden;

}
