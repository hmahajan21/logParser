package com.logparser.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventLog {
    @Id
    private String id;

    private Long duration;

    private Boolean alert;

    private String type;

    private String host;
}
