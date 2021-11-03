package com.logparser.dao;

import lombok.Data;

@Data
public class ServerLog {
    private Long timestamp;
    private String id;
    private String state;
    private String host;
    private String type;
}
