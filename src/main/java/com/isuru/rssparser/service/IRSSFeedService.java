package com.isuru.rssparser.service;

import com.isuru.rssparser.models.RssFeedEntry;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;

import java.util.List;

public interface IRSSFeedService {
    SyndFeed getRssFeed();
    List<RssFeedEntry> getFeedEntries();
}
