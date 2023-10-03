package com.fastcampus.helloecommeradmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class SearchResultController {

    @PostMapping(value = "/search")
    public String search(@RequestBody String keyword) {
        log.info("Search Keyword={}", keyword);
        return "/search/search-result-page";
    }
}
