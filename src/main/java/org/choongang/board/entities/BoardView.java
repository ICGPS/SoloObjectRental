package org.choongang.board.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BoardViewId.class)
public class BoardView {
    @Id
    private Long seq;   // 게시글 번호
    @Id
    @Column(name="_uid")    // uid : 오라클에서는 예약어라서 사용할 수 없음.
    private int uid;
}
