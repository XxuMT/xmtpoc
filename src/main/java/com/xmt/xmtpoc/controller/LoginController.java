package com.xmt.xmtpoc.controller;

import com.xmt.xmtpoc.dto.domain.UserInfo;
import com.xmt.xmtpoc.dto.request.LoginDTO;
import com.xmt.xmtpoc.repository.LoginRepository;
import com.xmt.xmtpoc.result.Result;
import com.xmt.xmtpoc.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 登陆Controller
 * @date 2019/4/28
 */
@Controller
@RequestMapping(value = "/wapi/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody LoginDTO dto, BindingResult bindingResult) {
        String message;
        if (bindingResult.hasErrors()) {
            message = "登陆失败，" + bindingResult.getFieldError().getDefaultMessage();
            return ResultFactory.fail(message);
        }
        UserInfo userInfo = loginRepository.findByUserNameAndUserPass(dto.getLoginName(), dto.getLoginPass());
        if (userInfo == null) {
            message = "登陆失败，用户名密码错误";
            return ResultFactory.fail(message);
        }
        return ResultFactory.success(dto);
    }

    @CrossOrigin
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public Result changePassword(@Valid LoginDTO dto, BindingResult bindingResult) {
        String message;
        if (bindingResult.hasErrors()) {
            message = "更新失败，" + bindingResult.getFieldError().getDefaultMessage();
            return ResultFactory.fail(message);
        }
        int count = loginRepository.modifyUserPassById(dto.getLoginPass(), dto.getId());
        if (count < 0) {
            message = "更新失败";
            return ResultFactory.fail(message);
        }
        return ResultFactory.success(dto);
    }
}
