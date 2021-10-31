package com.isuru.rssparser.service;

import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IRssFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LatestItemsServiceImpl implements ILatestItemsService{
    @Autowired
    IRssFeedRepository rssFeedRepository;

    /**
     * Get the most recent 10 updates of the given rss feed
     * @return
     */
    @Override
    public List<RssFeedEntry> fetchLatestItems()
    {
        return rssFeedRepository.findTop10ByOrderByPublicationDateDesc();
    }
}
