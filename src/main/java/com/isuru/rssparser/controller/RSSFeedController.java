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

    @GetMapping(value = "/items",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RssFeedEntry> fetchLatestItems()
    {
        return latestItemsService.fetchLatestItems();
    }

    @GetMapping(value = "/items",produces = {MediaType.APPLICATION_JSON_VALUE}, params = {"page", "size", "sort" })
    public List<RssFeedEntry> fetchPaginatedItems(@RequestParam("page") int page,
                                                  @RequestParam("size") int size,
                                                  @RequestParam("direction") String direction,
                                                  @RequestParam("sort") String sort)
    {

        return paginatedService.fetchPaginatedItems(page, size, direction, sort);

    }
}
