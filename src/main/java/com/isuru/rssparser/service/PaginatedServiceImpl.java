package com.isuru.rssparser.service;

import com.isuru.rssparser.entities.RssFeedEntry;
import com.isuru.rssparser.repository.IRssFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginatedServiceImpl implements IPaginatedService{
    @Autowired
    IRssFeedRepository rssFeedRepository;

    @Override
    public List<RssFeedEntry> fetchPaginatedItems(int page, int size, String direction, String sort) {
        Pageable pageableRequest;
        if("ascending".equalsIgnoreCase(direction)){
            pageableRequest= PageRequest.of(page, size, Sort.by(sort).ascending());
        }else {
            pageableRequest= PageRequest.of(page, size, Sort.by(sort).descending());;
        }
        return rssFeedRepository.findAll(pageableRequest).getContent();
    }
}
