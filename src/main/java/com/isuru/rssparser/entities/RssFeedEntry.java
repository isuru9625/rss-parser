package com.isuru.rssparser.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RssFeedEntry {
    @Id
    private long id;
    private String title;
    private String description;
    private String author;
    private String publicationDate;
}
