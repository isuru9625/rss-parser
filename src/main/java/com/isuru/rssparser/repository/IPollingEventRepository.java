package com.isuru.rssparser.repository;

import com.isuru.rssparser.entities.PollingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IPollingEventRepository extends JpaRepository<PollingEvent,Long> {
    Optional<PollingEvent> findTop1ByOrderByUpdatedTimeDesc();
}
