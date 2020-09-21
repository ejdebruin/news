package com.interview.news.service;

import com.interview.news.client.NewsClient;
import com.interview.news.models.ClientArticle;
import com.interview.news.models.ClientSearchResult;
import com.interview.news.models.ClientSource;
import com.interview.news.models.NewsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsClient newsClient;

    public List<NewsResult> retrieveSearchResults(String searchKeyword) {
        ClientSearchResult retrievedSearchResult = newsClient.retrieveSearchResults(searchKeyword);

        if (retrievedSearchResult != null) {
            return transformClientSearchResultToNewsResultList(retrievedSearchResult, searchKeyword);
        }
        return null;
    }

    private List<NewsResult> transformClientSearchResultToNewsResultList(ClientSearchResult clientSearchResult, String searchKeyword) {
        List<NewsResult> newsResultList = new ArrayList<>();

        List<String> sourceIds = clientSearchResult.getArticles().stream()
                .map(ClientArticle::getSource)
                .map(ClientSource::getId)
                .distinct()
                .collect(Collectors.toList());

        for (String source : sourceIds) {
            NewsResult newsResult = new NewsResult();
            newsResult.setSearchedKeyword(source);
            long sourceIdCount = clientSearchResult.getArticles().stream()
                    .filter(clientArticle -> clientArticle.getSource().getId().equals(source))
                    .count();
            newsResult.setArticleCount((int) sourceIdCount);
            newsResultList.add(newsResult);
        }

        return newsResultList;
    }
}