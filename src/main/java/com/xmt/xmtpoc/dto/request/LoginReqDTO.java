package com.xmt.xmtpoc.dto.request;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 变种Build模式DTO
 * @date 2019/8/22
 */

public class LoginReqDTO {
    private String loginName;

    private String loginPass;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public LoginReqDTO(String loginName, String loginPass) {
        this.loginName = loginName;
        this.loginPass = loginPass;
    }

    @Override
    public String toString() {
        return "LoginReqDTO{" +
                "loginName='" + loginName + '\'' +
                ", loginPass='" + loginPass + '\'' +
                '}';
    }

    public static LoginReqDTO.LoginReqDTOBuilder builder() {
        return new LoginReqDTO.LoginReqDTOBuilder();
    }

    public static class LoginReqDTOBuilder {

        private String loginName;
        private String loginPass;

        LoginReqDTOBuilder() {

        }

        public LoginReqDTO.LoginReqDTOBuilder loginName(String loginName) {
            this.loginName = loginName;
            return this;
        }

        public LoginReqDTO.LoginReqDTOBuilder loginPass(String loginPass) {
            this.loginPass = loginPass;
            return this;
        }

        public LoginReqDTO build() {
            return new LoginReqDTO(this.loginName, this.loginPass);
        }

        @Override
        public String toString() {
            return "LoginReqDTO.LoginReqDTOBuilder{" +
                    "loginName='" + loginName + '\'' +
                    ", loginPass='" + loginPass + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        LoginReqDTO loginReqDTO = LoginReqDTO.builder().loginName("xmt").loginPass("123qwe").build();
        System.out.println(loginReqDTO.toString());
    }
}
