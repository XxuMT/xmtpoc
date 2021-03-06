package com.xmt.xmtpoc.dto.request;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 登陆实体类
 * @date 2019/4/28
 */
@Data
public class LoginDTO {

    private Long id;

    @NotNull(message = "用户名不允许为空")
    private String loginName;

    @NotNull(message = "密码不允许为空")
    private String loginPass;
}
