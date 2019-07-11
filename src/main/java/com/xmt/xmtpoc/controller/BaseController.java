package com.xmt.xmtpoc.controller;

import com.xmt.xmtpoc.result.Result;
import com.xmt.xmtpoc.result.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 基础Controller
 * @date 2019/6/25
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/*", method = RequestMethod.OPTIONS)
    public Result handleOptions(){
        return ResultFactory.success("");
    }

}
