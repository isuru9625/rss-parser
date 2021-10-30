package com.isuru.rssparser.service;

import com.isuru.rssparser.models.RssFeedEntry;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class RSSFeedServiceImpl implements IRSSFeedService{

    final static Logger log = LoggerFactory.getLogger(RSSFeedServiceImpl.class);

    @Value("${rss.url}")
    private String rssUrl;

    @Override
    public SyndFeed getRssFeed() {
        SyndFeed feed=null;
        log.info("Extracting RSS feed from {}", rssUrl);
        try{
            XmlReader reader=new XmlReader(new URL(rssUrl));
            feed=new SyndFeedInput().build(reader);
        }catch (IOException | FeedException e){

        }

        return feed;
    }

    @Override
    public List<RssFeedEntry> getFeedEntries() {
         List<RssFeedEntry> feedEntries=new ArrayList<>();
         getRssFeed().getEntries()
                .stream()
                .forEach(e->{

                    feedEntries.add(
                            new RssFeedEntry(
                                    e.getTitle(),
                                    e.getDescription().getValue(),
                                    e.getPublishedDate().toString(),
                                    e.getAuthor()
                            )
                    );
                });
         return feedEntries;
    }
}
