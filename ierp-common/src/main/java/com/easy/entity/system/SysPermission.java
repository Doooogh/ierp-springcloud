package com.easy.entity.system;

import lombok.Data;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 11:08
 * @Version 1.0
 **/
@Data
public class SysPermission {
    private String id;
    private String parentId;
    private String name;
    private String type;
    private String path;
    private String permission;
    private Integer sort;
    private Integer disable;


}
