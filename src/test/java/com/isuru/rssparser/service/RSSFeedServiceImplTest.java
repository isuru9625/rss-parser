package com.isuru.rssparser.service;

import com.isuru.rssparser.RssParserApplicationTests;
import com.isuru.rssparser.entities.PollingEvent;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IPollingEventRepository;
import com.isuru.rssparser.repository.IRssFeedRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class RSSFeedServiceImplTest  extends RssParserApplicationTests{
    @Mock
    IPollingEventRepository eventRepository;

    @Mock
    @Autowired
    IRssFeedRepository feedRepository;

    @Mock
    RSSFeedServiceImpl feedService;

    @Mock
    SyndFeed syndFeed;

//    @Test
//    void getRssFeed() {
//    }
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    void getFeedEntries() {
        System.out.println("DDDD");
        Date date=new Date();
        PollingEvent event=new PollingEvent(10,date);
        RssFeedEntry[] entries={new RssFeedEntry("title","desc",date,"author",event),new RssFeedEntry("title","desc",date,"author",event)};


        //first polling
        Mockito.when(eventRepository.findTop1ByOrderByUpdatedTimeDesc()).thenReturn(null);

        Mockito.when(feedService.getRssFeed()).thenReturn(new SyndFeedImpl());

        //set of feeds from rss
        Mockito.when(syndFeed.getEntries()).thenReturn(Arrays.asList(null,null));

        //transforming
        Mockito.when(feedService.transform(any(SyndEntry.class),any(PollingEvent.class))).thenReturn(
                new RssFeedEntry("title","desc",date,"author",event)
        );

        Mockito.when(eventRepository.save(any(PollingEvent.class))).thenReturn(event);

        AtomicInteger counter= new AtomicInteger();
        feedService.getFeedEntries().forEach(e->{
            counter.getAndIncrement();
            assertEquals("ABC",entries[counter.get()]);
            System.out.println("**************");
        });
    }

}