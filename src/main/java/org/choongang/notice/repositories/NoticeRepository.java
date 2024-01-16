package org.choongang.notice.repositories;

import org.choongang.notice.entities.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByWriter(String writer);
}
