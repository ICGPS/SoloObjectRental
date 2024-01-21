package org.choongang.member.service;

public class MemberInfoHandler {
    private String newName;           // 새로운 이름
    private String newEmail;          // 새로운 이메일
    private String currentPassword;   // 현재 비밀번호

    // 생성자, 게터, 세터 등이 포함될 수 있습니다.

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    // 생성자 및 게터, 세터는 IDE나 롬복 등을 사용하여 자동으로 생성하는 것이 편리합니다.
}
