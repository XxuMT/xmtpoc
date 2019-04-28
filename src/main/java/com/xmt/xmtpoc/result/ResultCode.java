package com.xmt.xmtpoc.result;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 响应码枚举，参考 HTTP状态码的语义
 * @date 2019/4/28
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200),

    /**
     * 失败
     */
    FAIL(400),

    /**
     * 未认证（签名错误）
     */
    UNAUTHORIZED(401),

    /**
     * 接口不存在
     */
    NOTFOUND(404),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500)
    ;

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
