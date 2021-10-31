package com.isuru.rssparser.unit.Entities;

import com.isuru.rssparser.entities.PollingEvent;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IRssFeedRepository;
import com.isuru.rssparser.service.IPaginatedService;
import com.isuru.rssparser.service.PaginatedServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class RssFeedEntityTest {
    @Autowired
    IRssFeedRepository rssFeedRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testRssFeedEntity(){
        RssFeedEntry entry1 = rssFeedRepository.save( new RssFeedEntry("title1", "description1", new Date(1000), "author1", new PollingEvent()) );
        RssFeedEntry entry2 = rssFeedRepository.save( new RssFeedEntry("title2", "description2", new Date(2000), "author2", new PollingEvent()) );
        RssFeedEntry entry3 = rssFeedRepository.save( new RssFeedEntry("title3", "description3", new Date(3000), "author3", new PollingEvent()) );

        assertThat(entry1).hasFieldOrPropertyWithValue("title", "title1");
        assertThat(entry2).hasFieldOrPropertyWithValue("author", "author2");
        assertThat(entry3).hasFieldOrPropertyWithValue("description", "description3");
    }

    @Test
    public void testAllRestFeedEntities(){

        RssFeedEntry entry4 =  new RssFeedEntry("title4", "description4", new Date(4000), "author4", new PollingEvent()) ;
        entityManager.persist(entry4);
        RssFeedEntry entry5 = new RssFeedEntry("title5", "description5", new Date(5000), "author5", new PollingEvent()) ;
        entityManager.persist(entry5);
        RssFeedEntry entry6 =  new RssFeedEntry("title6", "description6", new Date(6000), "author6", new PollingEvent()) ;
        entityManager.persist(entry6);
        RssFeedEntry entry7 =  new RssFeedEntry("title7", "description7", new Date(7000), "author7", new PollingEvent()) ;
        entityManager.persist(entry7);

        Iterable<RssFeedEntry> entities = rssFeedRepository.findAll();
        assertThat(entities).hasSize(4).contains(entry4, entry5, entry6, entry7);
    }
}
