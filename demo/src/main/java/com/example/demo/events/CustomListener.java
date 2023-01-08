package com.example.demo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CustomListener implements ApplicationListener<CustomEvent> {
    private static final Logger LOG = Logger.getLogger(CustomListener.class.getName());

    @Override
    public void onApplicationEvent(CustomEvent event) {
        LOG.info("Thread:[" + Thread.currentThread().getName() + "] listen: [" + event.getMessage() + "] Name [" + event.hashCode() + "] START");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("Thread:[" + Thread.currentThread().getName() + "] listen: [" + event.getMessage() + "] END");
    }
}
