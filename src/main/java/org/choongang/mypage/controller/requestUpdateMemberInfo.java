package org.choongang.mypage.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class requestUpdateMemberInfo {

    @NotBlank
    @Size(min=8)
    private String password;

    @NotBlank
    @Size(min=8)
    private String newPassword;

    @NotBlank
    @Size(min=8)
    private String newConfirmPassword;


}
