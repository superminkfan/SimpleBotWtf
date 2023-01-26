package com.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringWTFApplication
{

   private static final Logger log = LogManager.getLogger(SpringWTFApplication.class);

    public static void main(String[] args) {

        log.debug("Debugging log");
        log.info("Info log");
        log.warn("Hey, This is a warning!");
        log.error("Oops! We have an Error. OK");
        log.fatal("Damn! Fatal error. Please fix me.");
        SpringApplication.run(SpringWTFApplication.class, args);
    }





}
