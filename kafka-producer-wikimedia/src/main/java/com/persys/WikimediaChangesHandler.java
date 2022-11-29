package com.persys;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangesHandler implements EventHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private String topic;

    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic)
    {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onClosed() throws Exception 
    {
        LOGGER.info("Event -> Connection closed.");
    }

    @Override
    public void onComment(String arg0) throws Exception 
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onError(Throwable arg0) 
    {
        LOGGER.info("Event -> Connection Error occured : {}", arg0.getMessage());
        
    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception 
    {
        LOGGER.info("Event Data -> {}", messageEvent.getData());
        kafkaTemplate.send(topic, messageEvent.getData());        
    }

    @Override
    public void onOpen() throws Exception 
    {
        LOGGER.info("Event -> Connection opened");
        
    }
    
    
}
