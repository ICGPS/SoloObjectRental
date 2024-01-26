package org.choongang.search.contorollers;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.BoardDataSearch;
import org.choongang.board.entities.BoardData;
import org.choongang.board.service.BoardInfoService;
import org.choongang.commons.ListData;
import org.choongang.commons.Utils;
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
@RequiredArgsConstructor
public class SearchController {

    private final BoardInfoService boardInfoService;
    private final Utils utils;

    @GetMapping("/searchResults")
    public String searchResults(Model model, @RequestParam(value = "skey", required = false) String keyword) {

        BoardDataSearch search = new BoardDataSearch();
        search.setSopt("ALL");
        search.setSkey(keyword);
        ListData<BoardData> data = boardInfoService.getList(search);


        model.addAttribute("items", data.getItems());
        model.addAttribute("pagination", data.getPagination());

        return utils.tpl("search/searchResults");
    }
}























