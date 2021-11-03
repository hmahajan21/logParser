DROP TABLE IF EXISTS EVENT_LOG;

CREATE TABLE EVENT_LOG (
   id VARCHAR(250) PRIMARY KEY,
   host VARCHAR(50),
   type VARCHAR(20),
   duration FLOAT NOT NULL,
   alert BOOLEAN NOT NULL
);