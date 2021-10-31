package com.isuru.rssparser.unit.service;

import com.isuru.rssparser.entities.PollingEvent;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.service.RSSFeedServiceImpl;
import com.rometools.rome.feed.synd.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RSSFeedServiceTest {

    @Autowired
    private RSSFeedServiceImpl rssFeedService;

    @Test
    public void testTransformMethod(){

        Date current = new Date();
        SyndEntry entry = new SyndEntryImpl();
        entry.setTitle("ABC");
        SyndContent content = new SyndContentImpl();
        content.setValue("description");
        entry.setDescription(content);
        entry.setPublishedDate( current);
        entry.setAuthor("author");

        RssFeedEntry rssFeedEntry = rssFeedService.transform( entry, new PollingEvent(10,new Date()) );

        Assert.assertEquals("ABC", rssFeedEntry.getTitle());
        Assert.assertEquals("author", rssFeedEntry.getAuthor());
        Assert.assertEquals("description", rssFeedEntry.getDescription());
        Assert.assertEquals(current, rssFeedEntry.getPublicationDate());
    }
}
