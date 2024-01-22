package org.choongang.search.contorollers;

import org.choongang.search.entities.Search;
import org.choongang.search.repositories.SearchRepository;
import org.choongang.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

@Controller("SearchController")
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/searchResults")
    public String searchResults(Model model, @RequestParam(value = "skey", required = false) String keyword) {
        List<Search> searchResults = searchService.searchResults(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchResults", searchResults);
        return "front/search/searchResults";
    }
}























