package com.example.demo.events;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CustomPublisher {

    private static final Logger LOG = Logger.getLogger(CustomPublisher.class.getName());

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(String message) {
        LOG.info("Thread:[" + Thread.currentThread().getName() + "]");
        LOG.info("Publishing custom event. ");
        CustomEvent customEvent = new CustomEvent(this, message);
        for(int i=0; i<5; i++) {
            message = "customMessage[" + i + "]";
            customEvent = new CustomEvent(this, message);
            LOG.info("Thread:[" + Thread.currentThread().getName() + "] publish: " + customEvent.getMessage());
            applicationEventPublisher.publishEvent(customEvent);
        }
    }

}
