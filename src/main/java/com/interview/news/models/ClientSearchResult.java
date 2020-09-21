package com.interview.news.models;

import java.io.Serializable;
import java.util.List;

public class ClientSearchResult implements Serializable {

    private String status;

    private Integer totalResults;

    private List<ClientArticle> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<ClientArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<ClientArticle> articles) {
        this.articles = articles;
    }
}
