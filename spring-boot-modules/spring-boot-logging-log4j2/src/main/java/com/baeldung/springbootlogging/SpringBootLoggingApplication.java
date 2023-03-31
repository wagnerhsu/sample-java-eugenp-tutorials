package com.baeldung.springbootlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootLoggingApplication.class);

    public static void main(String[] args) {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        SpringApplication.run(SpringBootLoggingApplication.class, args);
    }
}
