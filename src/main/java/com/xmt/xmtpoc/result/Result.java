package com.xmt.xmtpoc.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 统一 API响应结果封装
 * @date 2019/4/28
 */

@Data
@AllArgsConstructor
public class Result {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应提示信息
     */
    private String message;

    /**
     * 响应结果对象
     */
    private Object data;
}
