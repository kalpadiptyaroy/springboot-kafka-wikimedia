package com.persys;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducer 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
    private static final String URL = "https://stream.wikimedia.org/v2/stream/recentchange";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage()
    {
        String topic = "wikimedia_recentchange";

        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(URL));
        EventSource eventSource = builder.build();

        eventSource.start();
        try 
        {
            TimeUnit.SECONDS.sleep(3);
        } 
        catch (InterruptedException e) 
        {
            LOGGER.error("The thread is Interrupted.", e);
            Thread.currentThread().interrupt();
        }
        eventSource.close();
    }
}
