package com.isuru.rssparser.unit.service;

import com.isuru.rssparser.entities.PollingEvent;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IPollingEventRepository;
import com.isuru.rssparser.repository.IRssFeedRepository;
import com.isuru.rssparser.service.IPaginatedService;
import com.isuru.rssparser.service.PaginatedServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PaginatedServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Mock
    IRssFeedRepository rssFeedRepository;

    @Mock
    IPollingEventRepository eventRepository;

    @InjectMocks
    PaginatedServiceImpl paginatedService;


    @Test
    public void testPaginatedItemsGet(){

        PollingEvent event1 = eventRepository.save( new PollingEvent() );
        PollingEvent event2 = eventRepository.save( new PollingEvent() );


        RssFeedEntry entry4 =  new RssFeedEntry("title4", "description4", new Date(4000), "author4", new PollingEvent()) ;
        entityManager.persist(entry4);
        RssFeedEntry entry5 = new RssFeedEntry("title5", "description5", new Date(5000), "author5", new PollingEvent()) ;
        entityManager.persist(entry5);
        RssFeedEntry entry6 =  new RssFeedEntry("title6", "description6", new Date(6000), "author6", new PollingEvent()) ;
        entityManager.persist(entry6);
        RssFeedEntry entry7 =  new RssFeedEntry("title7", "description7", new Date(7000), "author7", new PollingEvent()) ;
        entityManager.persist(entry7);

        System.out.println(paginatedService);
        System.out.println(rssFeedRepository);
        assertThat(paginatedService.fetchPaginatedItems(1,2,"asc", "publicationDate")).isEqualTo(null);

    }
}
