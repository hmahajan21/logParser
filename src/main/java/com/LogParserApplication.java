package com;

import com.logparser.service.ParserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAutoConfiguration
@Slf4j
public class LogParserApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(LogParserApplication.class, args);
	}

    @Autowired
	ParserServiceImpl parserServiceImp;

	@Override
	public void run(String... args) throws Exception {
		log.info("In CommandLineRunnerImpl ");

		if (args == null || args.length != 1) {
			log.error("Arguments should be in the format --args='<File>'.");
			throw new IllegalArgumentException("Please check the arguments and run again.");
		}
		String path=args[0];
		parserServiceImp.readLargeJson(path);
	}
}


