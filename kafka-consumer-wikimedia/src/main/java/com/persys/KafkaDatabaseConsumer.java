package com.persys;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persys.entity.WikimediaData;
import com.persys.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;
    
    @KafkaListener(topics="wikimedia_recentchange", groupId = "myGroup")
    public void consumeGroup(String eventMessage)
    {
        LOGGER.info("Message Received <- \n\n{}\n", eventMessage);

        WikimediaData wikimediaData = getDataAsObject(eventMessage);
        LOGGER.info("JSON Converted to Java Object");

        wikimediaDataRepository.save(wikimediaData);
        LOGGER.info("Data Stored in Repository");
    }

    public WikimediaData getDataAsObject(String data)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        WikimediaData wikimediaData = null;
        try
        {
            wikimediaData = objectMapper.readValue(data, WikimediaData.class);
        }
        catch(IOException e)
        {
            LOGGER.error("Error occured while parsing JSON String - {}", e.getMessage());
        }
        return wikimediaData;
    }
}