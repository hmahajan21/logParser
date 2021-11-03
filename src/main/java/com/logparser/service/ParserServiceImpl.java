package com.logparser.service;

import com.google.gson.Gson;
import com.logparser.Entity.EventLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logparser.dao.ServerLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@Service
public class ParserServiceImpl {

    @Autowired
    EventServiceImpl eventService;

    public void readLargeJson(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        HashMap<String, ServerLog> eventMap = new HashMap<>();
        Gson gson = new Gson();
        String line;
        while ((line = reader.readLine()) != null) {
            ServerLog log = gson.fromJson(line, ServerLog.class);
            String eventId = log.getId();
            if (!eventMap.containsKey(eventId)) {
                eventMap.put(eventId, log);
                continue;
            }

            ServerLog previousLog = eventMap.remove(eventId);
            Long duration= Math.abs(log.getTimestamp() - previousLog.getTimestamp());

            Boolean alert = false;
            if (duration > 4) {
                alert = true;
            }

            EventLog event = new EventLog().builder().
                    id(eventId).
                    alert(alert).
                    duration(duration).
                    host(log.getHost()).
                    type(log.getType()).
                    build();
            eventService.createEventLog(event);
        }
    }
}
