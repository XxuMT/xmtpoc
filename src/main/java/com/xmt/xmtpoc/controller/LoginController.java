package com.xmt.xmtpoc.controller;

import com.xmt.xmtpoc.pojo.LoginDTO;
import com.xmt.xmtpoc.result.Result;
import com.xmt.xmtpoc.result.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 登陆Controller
 * @date 2019/4/28
 */
@Controller
@RequestMapping(value = "/wapi/login")
public class LoginController {

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@Valid LoginDTO dto, BindingResult bindingResult) {
        String message;
        if (bindingResult.hasErrors()) {
            message = "登陆失败，" + bindingResult.getFieldError().getDefaultMessage();
            return ResultFactory.fail(message);
        }
        if (!"xmt".equals(dto.getLoginName()) || !"12345qwert".equals(dto.getLoginPass())) {
            message = "登陆失败，用户名密码错误";
            return ResultFactory.fail(message);
        }
        return ResultFactory.success(dto);
    }
}
