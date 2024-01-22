package org.choongang.search.service;

import org.choongang.search.entities.Search;

import java.util.List;

public interface SearchService {

    List<Search> searchResults(String keyword);

}
