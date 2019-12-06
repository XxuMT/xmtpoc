package com.xmt.xmtpoc.controller;

import com.xmt.xmtpoc.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 上传文件
 * @date 2019/7/16
 */
@Controller
@RequestMapping(value = "/wapi/upload")
public class UploadController {

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadImage(@RequestParam MultipartFile file) {
        return null;
    }
}
