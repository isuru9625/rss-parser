package com.isuru.rssparser.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Poll;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class RssFeedEntry {

    public RssFeedEntry(String title, String desc, String publicationDate, String author, PollingEvent event){
        this.title=title;
        this.description=desc;
        this.author=author;
        this.publicationDate=publicationDate;
        this.pollingEvent=event;
    }

    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Lob
    private String description;
    private String author;
    private String publicationDate;

    @ManyToOne
    @JoinColumn(name = "pollingEventId")
    PollingEvent pollingEvent;
}
