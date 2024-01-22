package org.choongang.search.contorollers;

import org.choongang.search.entities.Search;
import org.choongang.search.repositories.SearchRepository;
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

    private SearchRepository searchRepository;

    @Autowired
    public SearchController(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @GetMapping("/searchResults")
    public String searchResults(Model model, @RequestParam String keyword) {

        List<Search> searchResults = searchRepository.findByBoardNameAndTitleContainingOrBoardNameAndContentContaining("board1", keyword, "board2", keyword);
        model.addAttribute("searchResults", searchResults);

        return "search/searchResults";
    }


}























