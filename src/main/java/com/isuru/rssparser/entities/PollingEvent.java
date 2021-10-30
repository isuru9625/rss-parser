package com.isuru.rssparser.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="Polling_Event")
public class PollingEvent {
    @Id
    @GeneratedValue
    private long id;
    private long updatedRowCount;
    private long updatedTime;
}
