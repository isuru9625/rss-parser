package com.isuru.rssparser.service;

import com.isuru.rssparser.entities.RssFeedEntry;

import java.util.List;

public interface ILatestItemsService {
    public List<RssFeedEntry> fetchLatestItems();
}
