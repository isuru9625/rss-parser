package com.isuru.rssparser.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class RssFeedEntry {
    private String title;
    private String description;
    private String publicationDate;
    private String author;
}
