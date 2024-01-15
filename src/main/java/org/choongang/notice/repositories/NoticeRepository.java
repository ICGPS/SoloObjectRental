package org.choongang.notice.repositories;

import org.choongang.notice.entities.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
