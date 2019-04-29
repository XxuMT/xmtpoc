package com.xmt.xmtpoc.dto.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 用户信息表实体
 * @date 2019/4/28
 */
@Data
@Entity(name = "t_user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pass")
    private String userPass;
}
