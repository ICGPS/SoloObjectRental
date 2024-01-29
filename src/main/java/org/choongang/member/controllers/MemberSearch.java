package org.choongang.member.controllers;

import lombok.Data;

@Data
public class MemberSearch {
    private int page = 1;
    private int limit = 20;

    private String userId;
    private String name;

    private String sopt;
    private String skey;
}
