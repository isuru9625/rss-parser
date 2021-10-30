package com.isuru.rssparser.service;

import com.isuru.rssparser.repository.IPollingEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;

@Service
public class PollerSchedulerService {

    private static final Logger log = LoggerFactory.getLogger(PollerSchedulerService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    IRSSFeedService rssFeedService;

    @Autowired
    IPollingEventRepository eventRepository;

    @Scheduled(fixedRate = 60000)
    public void pollRssFeed() {
        rssFeedService.getFeedEntries();

    }
}
