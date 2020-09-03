package com.easy.common.entity.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author li long
 * @Description --
 * @Date 2020/9/3 14:36
 * @Param
 * @return
 **/

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SysUser {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private String clientId;
    private List<String> roles;
}
