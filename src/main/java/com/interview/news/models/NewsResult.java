package com.interview.news.models;

import java.io.Serializable;

public class NewsResult implements Serializable {

    private Integer articleCount;

    private String searchedKeyword;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public String getSearchedKeyword() {
        return searchedKeyword;
    }

    public void setSearchedKeyword(String searchedKeyword) {
        this.searchedKeyword = searchedKeyword;
    }
}
