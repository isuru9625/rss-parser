package com.isuru.rssparser.service;

import com.isuru.rssparser.entities.RssFeedEntry;

import java.util.List;

public interface IPaginatedService
{
    List<RssFeedEntry> fetchPaginatedItems(int page, int size, String direction, String sort);
}
