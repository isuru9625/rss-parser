package com.isuru.rssparser.controller;

import com.isuru.rssparser.models.RssFeedEntry;
import com.isuru.rssparser.service.RSSFeedServiceImpl;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/v1/rssFeed")
public class RSSFeedController {

    @Autowired
    RSSFeedServiceImpl rssFeedService;

    @GetMapping(value = "/test",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RssFeedEntry> test(){
        return rssFeedService.getFeedEntries();
    }
}
