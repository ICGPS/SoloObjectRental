package org.choongang.mypage.controllers;

import lombok.Data;

@Data
// 커맨드 객체(RequestResign) 추가
public class RequestResign {
    private String mode = "step1";
    private String password;
    private String confirmPassword;
    private Integer authCode;
}
