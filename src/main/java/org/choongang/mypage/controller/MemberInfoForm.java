package org.choongang.mypage.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberInfoForm {
    private String name;
    private String email;
    private String tel;
    private String address;
    // 다른 필드들...

    // 각 필드에 대한 getter와 setter 메서드들도 추가해야 합니다.

    // 다른 필드에 대한 getter와 setter 메서드들...
}