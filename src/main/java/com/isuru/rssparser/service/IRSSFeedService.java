package com.isuru.rssparser.service;

import com.isuru.rssparser.entities.PollingEvent;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;

public interface IRSSFeedService {
    SyndFeed getRssFeed();
    void getFeedEntries();
    RssFeedEntry transform(SyndEntry entries,PollingEvent event);
}
