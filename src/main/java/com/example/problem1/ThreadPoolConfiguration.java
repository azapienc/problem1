package com.example.problem1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@Slf4j
public class ThreadPoolConfiguration {
    @Bean
    public ExecutorService getThreadPool(){
        log.info("Setting thread pool");
        return Executors.newFixedThreadPool(2);
    };
}

