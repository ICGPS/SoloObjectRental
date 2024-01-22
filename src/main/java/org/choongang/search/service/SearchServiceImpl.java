package org.choongang.search.service;

import org.choongang.search.entities.Search;
import org.choongang.search.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public List<Search> searchResults(String keyword) {

        return searchRepository.findByTitleContainingOrContentContaining(keyword, keyword);

    }

}
