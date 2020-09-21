package com.interview.news.client;

import com.interview.news.models.ClientSearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
public class NewsClient {

    private RestTemplate restTemplate = new RestTemplate();

    private final String API_KEY = "21cf2ab22852408a8bf5ea63cd6131f0";

    private final String NEWS_URL = "https://newsapi.org/v2/top-headlines?";

    public ClientSearchResult retrieveSearchResults(String keyword) {
        MultiValueMap<String, String> queryParameterMap = new LinkedMultiValueMap<>();
        queryParameterMap.add("q", keyword);
        queryParameterMap.add("apiKey", API_KEY);

        UriComponents urlComponents = UriComponentsBuilder.fromHttpUrl(NEWS_URL).queryParams(queryParameterMap).build();

        System.out.println("Url String : " + urlComponents.toString());
        ResponseEntity<ClientSearchResult> newsApiResponse =
                restTemplate.getForEntity(urlComponents.toUri(), ClientSearchResult.class);

        if (newsApiResponse.getStatusCode().is2xxSuccessful()) {
            return newsApiResponse.getBody();
        } else {
            return null;
        }
    }

}