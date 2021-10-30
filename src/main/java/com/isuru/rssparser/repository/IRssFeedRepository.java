package com.isuru.rssparser.repository;

import com.isuru.rssparser.entities.RssFeedEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface IRssFeedRepository extends PagingAndSortingRepository<RssFeedEntry,Long> {
    List<RssFeedEntry> findTop10ByOrderByPublicationDateDesc();
    Page<RssFeedEntry> findAll(Pageable pageable);
}
