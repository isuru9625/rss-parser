package com.isuru.rssparser.repository;

import com.isuru.rssparser.entities.RssFeedEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRssFeedRepository extends JpaRepository<RssFeedEntry,Long> {
}
