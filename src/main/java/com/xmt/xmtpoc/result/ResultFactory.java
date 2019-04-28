package com.xmt.xmtpoc.result;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 响应结果生成工厂类
 * @date 2019/4/28
 */
public class ResultFactory {

    public static Result success(Object data) {
        return result(ResultCode.SUCCESS, "成功", data);
    }

    public static Result fail(String message) {
        return result(ResultCode.FAIL, message, null);
    }

    public static Result result(ResultCode resultCode, String message, Object data) {
        return result(resultCode.code, message, data);
    }

    public static Result result(int code, String message, Object data) {
        return new Result(code, message, data);
    }
}
