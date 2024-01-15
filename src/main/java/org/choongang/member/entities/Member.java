package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.entities.Base;
import org.choongang.file.entities.FileInfo;
import org.choongang.member.controllers.RequestJoin;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member extends Base {
    @Id @GeneratedValue
    private Long seq;

    @Column(length=65, nullable = false)
    private String gid;

    @Column(length=80, nullable = false, unique = true)
    private String email;

    @Column(length=40, nullable = false, unique = true)
    private String userId;

    @Column(length=65, nullable = false)
    private String password;

    @Column(length=40, nullable = false)
    private String name;

    /* 추가 내용 S */
    @Column(length=20, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String tel;

    @Column(length=7, nullable = false)
    private String bDay;

    /* 추가 엔티티 S */

    // 약관 동의 상태 확인, 동의 / 미동의로 구분
    @Enumerated(EnumType.STRING)
    private AgreementStatus agree;

    // 회원의 탈퇴 여부 확인, 탈퇴 / 미탈퇴로 구분
    @Enumerated(EnumType.STRING)
    private ExfireStatus exfire;

    /* 추가 엔티티 E */


//    @Column(length=20)
    //    private String nation;  // 국적
    /* 추가 내용 E */

    @Column(length=10)
    private String zonecode;

    @Column(length=100)
    private String address;

    @Column(length=100)
    private String addressSub;

    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Authorities> authorities = new ArrayList<>();

    @Transient
    private FileInfo profileImage;
}
