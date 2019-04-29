package com.xmt.xmtpoc.repository;

import com.xmt.xmtpoc.dto.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 登陆JPA
 * @date 2019/4/28
 */
public interface LoginRepository extends JpaRepository<UserInfo, Long> {

    /**
     *
     * description: 根据用户名和密码查询用户信息
     *
     * @author mengting.xu
     * @date 2019/4/28 17:23
     * @param userName
     * @param userPass
     * @return
     */
    UserInfo findByUserNameAndUserPass(String userName, String userPass);
}
