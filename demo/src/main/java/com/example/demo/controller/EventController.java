package com.example.demo.controller;

import com.example.demo.events.CustomPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class EventController {

    @Autowired
    CustomPublisher customPublisher;

    @GetMapping("/event")
    public void triggerEvent() throws InterruptedException {
        System.out.println("Thread:[" + Thread.currentThread().getName() + "] event 1");
        Thread.sleep(3000);
        System.out.println("endpoint 1");
        // customPublisher.publishCustomEvent("eventPublished");
    }

    @GetMapping("/event2")
    public void triggerEvent2() throws InterruptedException {
        System.out.println("Thread:[" + Thread.currentThread().getName() + "] event 2");
        Thread.sleep(3000);
        System.out.println("endpoint 2");
        // customPublisher.publishCustomEvent("eventPublished");
    }

}
