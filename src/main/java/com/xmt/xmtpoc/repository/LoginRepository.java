package com.xmt.xmtpoc.repository;

import com.xmt.xmtpoc.dto.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     *
     * description: 根据Id修改密码
     *
     * 需要加上注解 @Transactional 开启事务，不然报错
     * javax.persistence.TransactionRequiredException: Executing an update/delete query
     *
     * @author mengting.xu
     * @date 2019/4/30 11:07
     * @param id
     * @param userPass
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class, timeout = 10)
    @Query("update UserInfo user set user.userPass = ?1 where user.id = ?2")
    int modifyUserPassById(String userPass, Long id);
}
