package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.entities.Base;
import org.choongang.file.entities.FileInfo;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member extends Base {
    @Id @GeneratedValue
    private Long seq;

    @Column(length=65, nullable = false)
    private String gid;

    @Column(length=40, nullable = false, unique = true)
    private String userId;

    @Column(length=65, nullable = false)
    private String password;

    @Column(length=80, nullable = false, unique = true)
    private String email;

    @Column(length=40, nullable = false)
    private String name;

    /* 추가 내용 S */
    @Column(length=20, nullable = false)
    private String userName; // 닉네임

    @Column(length=7, nullable = false)
    private String bDay;

    @Column(length=100)
    private String address;

    @Column(nullable = false)
    private String tel;

    /* 추가 내용 E */

/*
    @Column(length=20)
    private String nation;  // 국적
*/

    @Column(length=10)
    private String zonecode; // 우편번호

    @Column(length=100)
    private String addressSub; // 서브 주소

    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Authorities> authorities = new ArrayList<>();

    @Transient
    private FileInfo profileImage;

//    private boolean enable = true;
}
