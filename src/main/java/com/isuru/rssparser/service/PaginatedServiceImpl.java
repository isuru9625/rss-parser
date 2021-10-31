package com.isuru.rssparser.service;

import com.isuru.rssparser.constants.Constant;
import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IRssFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginatedServiceImpl implements IPaginatedService{
    @Autowired
    IRssFeedRepository rssFeedRepository;

    /**
     * Get the filtered out rss feed entries
     * @param page page number
     * @param size number of entries
     * @param direction whether it is in ascending order or descending order
     * @param sort the parameter of sorting
     * @return
     */
    @Override
    public List<RssFeedEntry> fetchPaginatedItems(int page, int size, String direction, String sort)
    {
        List<RssFeedEntry> rssFeedEntries = new ArrayList<>();
        Pageable pageableRequest ;
        if(Constant.ASC.equalsIgnoreCase(direction))
        {
            pageableRequest= PageRequest.of(page, size, Sort.by(sort).ascending());
        }else if(Constant.DSC.equalsIgnoreCase(direction))
        {
            pageableRequest= PageRequest.of(page, size, Sort.by(sort).descending());
        }
        else
        {
            pageableRequest= PageRequest.of(page, size, Sort.by(sort).descending());
        }
        rssFeedEntries = rssFeedRepository.findAll(pageableRequest).getContent();
        return rssFeedEntries;
    }
}
