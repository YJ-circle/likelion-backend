package com.inspire12.likelionbackend.controller;

import com.inspire12.likelionbackend.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ThreadTestController {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private final ThreadService threadService;

    @GetMapping
    public String hello() throws InterruptedException {
        log.info("hello");
        threadService.executeThreads();
        return "hello";
    }
}
