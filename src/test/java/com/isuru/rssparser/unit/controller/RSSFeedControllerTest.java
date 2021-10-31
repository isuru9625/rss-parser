package com.isuru.rssparser.unit.controller;

import com.isuru.rssparser.controller.RSSFeedController;
import com.isuru.rssparser.entities.PollingEvent;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IRssFeedRepository;
import com.isuru.rssparser.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.TestAnnotationUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RSSFeedControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLatestItemsEndPoint() throws Exception {
        mockMvc.perform(get("/v1/rssFeed/items")).andExpect(status().isOk());
    }

    @Autowired
    IRSSFeedService feedService;

    @Autowired
    IPaginatedService paginatedService;

    @Test
    public void testPaginatedItemsEndPoint() throws Exception {

        RssFeedEntry entry1 = new RssFeedEntry("title1","description1", new Date(), "author1", new PollingEvent());
        RssFeedEntry entry2 = new RssFeedEntry("title2","description2", new Date(), "author2", new PollingEvent());

        LatestItemsServiceImpl mock = org.mockito.Mockito.mock(LatestItemsServiceImpl.class);

        RSSFeedServiceImpl mockfeed = org.mockito.Mockito.mock(RSSFeedServiceImpl.class);

        PaginatedServiceImpl mockpaginatedService = org.mockito.Mockito.mock(PaginatedServiceImpl.class);

        when(mock.fetchLatestItems()).thenReturn(Arrays.asList(entry1, entry2));
        when(mockfeed.getFeedEntries()).thenReturn(Arrays.asList(entry1, entry2));


        mockMvc.perform(get("/v1/rssFeed/items")).andExpect(status().isOk())
                      .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$", hasSize(2)));
    }

}
