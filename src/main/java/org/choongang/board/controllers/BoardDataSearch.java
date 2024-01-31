package org.choongang.board.controllers;

import lombok.Data;

import java.util.List;

@Data
public class BoardDataSearch {
    private int page  = 1;
    private int limit;  // 0 : 설정에 있는 1페이지 게시글 갯수, 1 이상 : 지정한 갯수로

    /**
     * 검색 옵션(search option)
     *
     * subject : 제목
     * content : 내용
     * subject_content : 제목 + 내용
     * poster : 작성자명 + 아이디 + 회원 이름 (OR)
     * ALL :
     */
    private String sopt;    // 검색 옵션
    private String skey;    // 검색 키워드

    private List<String> bid;   // 게시판 id

    private String userId;

    private String category;    // 게시판 분류

    private List<Long> seq; // 게시글 번호
}
