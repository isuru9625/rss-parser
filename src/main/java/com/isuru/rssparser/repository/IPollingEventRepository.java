package com.isuru.rssparser.repository;

import com.isuru.rssparser.entities.PollingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPollingEventRepository extends JpaRepository<PollingEvent,Long> {
}
