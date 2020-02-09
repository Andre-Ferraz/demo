package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Media {

    private Integer id;
    private final String name;
    private final String url;
    private final Integer length;

    public Media(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("url") String url,
            @JsonProperty("length") Integer length) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.length = length;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Integer getLength() {
        return length;
    }
}
