package com.logparser.repository;

import com.logparser.Entity.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventLog, String> {
}
