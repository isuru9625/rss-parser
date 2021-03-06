package com.isuru.rssparser.controller;

import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.service.ILatestItemsService;
import com.isuru.rssparser.service.IPaginatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/rssFeed")
public class RSSFeedController {

    @Autowired
    ILatestItemsService latestItemsService;

    @Autowired
    IPaginatedService paginatedService;

    /**
     * Get end point to get the latest ten rss feed entries of the given rss feed
     * @return
     */
//    @GetMapping(value = "/items",produces = {MediaType.APPLICATION_JSON_VALUE})
//    public List<RssFeedEntry> fetchLatestItems()
//    {
//        return latestItemsService.fetchLatestItems();
//    }

    /**
     * Get end point to get the rss feed entries of the given rss feed according to pagination criteria
     * @param page page number
     * @param size number of records in one page
     * @param direction whether it is in ascending order or descending order
     * @param sort the parameter of sorting
     * @return
     */
    @GetMapping(value = "/items",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RssFeedEntry> fetchPaginatedItems(@RequestParam(required = false, defaultValue = "0") int page,
                                                  @RequestParam(required = false, defaultValue = "10") int size,
                                                  @RequestParam(required = false, defaultValue = "dsc") String direction,
                                                  @RequestParam(required = false, defaultValue = "publicationDate") String sort)
    {

        return paginatedService.fetchPaginatedItems(page, size, direction, sort);

    }
}
