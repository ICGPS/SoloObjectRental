package org.choongang.search.repositories;

import org.choongang.search.entities.Search;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<Search, Long> {

    List<Search> findByBoardNameAndTitleContainingOrBoardNameAndContentContaining(String boardName1, String keyword1, String boardName2, String keyword2);
}
