package com.xmt.xmtpoc.repository;

import com.xmt.xmtpoc.pojo.LoginDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 登陆JPA
 * @date 2019/4/28
 */
public interface LoginRepository extends JpaRepository<LoginDTO, Long> {
}
