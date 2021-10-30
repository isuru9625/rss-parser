package com.isuru.rssparser.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="Polling_Event")
@NoArgsConstructor
@ToString
public class PollingEvent {
    @Id
    @GeneratedValue
    private long id;
    private long updatedRowCount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @OneToMany(mappedBy = "pollingEventId")
    @Transient
    List<RssFeedEntry> feeds;

    public PollingEvent(long updatedRowCount, Date updatedTime) {
        this.updatedRowCount=updatedRowCount;
        this.updatedTime=updatedTime;
    }
}
