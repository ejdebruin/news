package com.interview.news.controller;

import com.interview.news.models.NewsResult;
import com.interview.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/search", produces = {"application/json"})
    public ResponseEntity<List<NewsResult>> retrieveSearchResults(
            @RequestParam("keyword") final String keyword
    ) {
        return new ResponseEntity<>(newsService.retrieveSearchResults(keyword), HttpStatus.OK);
    }
}