package com.isuru.rssparser.service;

import com.isuru.rssparser.RssParserApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LatestItemsServiceImplTest extends RssParserApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    IRSSFeedService irssFeedService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLatestItemsEndPoint() throws Exception {
        mockMvc.perform(get("/v1/rssFeed/items")).andExpect(status().isOk());
    }

//    @Test
//    public void testFetchPaginatedItems() throws Exception {
//        irssFeedService.getFeedEntries();
//        mockMvc.perform(get("v1/rssFeed/items")).andExpect(status().isOk())
//                .andExpect(content().contentType("application/json"));
//    }
}