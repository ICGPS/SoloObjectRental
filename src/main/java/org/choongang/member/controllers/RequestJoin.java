package org.choongang.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestJoin {

    private String gid = UUID.randomUUID().toString();

    @NotBlank @Email
    private String email;

    @NotBlank
    @Size(min=6)
    private String userId;

    @NotBlank
    @Size(min=8)
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String name;

    /* 추가 내용 S */
    @NotBlank
    private String userName;    // 닉네임

    @NotBlank
    private String bDay;    // 생년월일 + 1자리

    @NotBlank
    @Size(min=10, max=11)
    private String tel;

    @NotBlank
    private String address;     // 주소

//    @NotBlank
//    private String nation;  // 국적

    /* 추가 내용 E */

    @AssertTrue
    private boolean agree;

}
