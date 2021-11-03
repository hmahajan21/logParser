package com.logparser.service;

import com.logparser.Entity.EventLog;
import com.logparser.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl {
    @Autowired
    EventRepository eventRepository;

    public void createEventLog(EventLog eventLog){
        eventRepository.save(eventLog);
    }
}
