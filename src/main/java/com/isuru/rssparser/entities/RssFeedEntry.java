package com.isuru.rssparser.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class RssFeedEntry {

    public RssFeedEntry(String title, String desc, Date publicationDate, String author, PollingEvent event){
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date publicationDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pollingEventId")
    PollingEvent pollingEvent;
}
