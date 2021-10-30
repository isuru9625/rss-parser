package com.isuru.rssparser.service;

import com.isuru.rssparser.entities.PollingEvent;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IPollingEventRepository;
import com.isuru.rssparser.repository.IRssFeedRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RSSFeedServiceImpl implements IRSSFeedService{

    final static Logger log = LoggerFactory.getLogger(RSSFeedServiceImpl.class);

    @Value("${rss.url}")
    private String rssUrl;

    @Autowired
    IPollingEventRepository eventRepository;

    @Autowired
    IRssFeedRepository feedRepository;

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
    public void getFeedEntries() {
         List<RssFeedEntry> feedEntries=new ArrayList<>();
         Optional<PollingEvent> lastEvent=eventRepository.findTop1ByOrderByUpdatedTimeDesc();

        PollingEvent event=eventRepository.save(new PollingEvent(0,new Date()));

         if(lastEvent.isPresent()){
             log.info("Last event occurred at: {}",lastEvent.get().getUpdatedTime());
             getRssFeed().getEntries()
                     .forEach(e->{
                         if(e.getPublishedDate().compareTo(lastEvent.get().getUpdatedTime()) > 0){
                             feedEntries.add(transform(e,event));
                         }
                     });
         }else{
             log.info("Initial polling...");
             getRssFeed().getEntries().forEach(e->{
                         feedEntries.add(transform(e,event));
                     });
         }

         event.setUpdatedRowCount(feedEntries.size());
         eventRepository.save(event);
         feedRepository.saveAll(feedEntries);
    }

    @Override
    public RssFeedEntry transform(SyndEntry entry,PollingEvent event) {
        return new RssFeedEntry(
                entry.getTitle(),
                entry.getDescription().getValue(),
                entry.getPublishedDate(),
                entry.getAuthor(),
                event
        );
    }
}
