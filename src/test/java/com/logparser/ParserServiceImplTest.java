package com.logparser;

import com.logparser.service.EventServiceImpl;
import com.logparser.service.ParserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ParserServiceImplTest {

    @InjectMocks
    ParserServiceImpl parserService;

    @Mock
    EventServiceImpl eventService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldParseAndSaveEvents() throws IOException {
        parserService.readLargeJson("src/test/resources/log.txt");
        verify(eventService,times(3)).createEventLog(any());
    }
}
