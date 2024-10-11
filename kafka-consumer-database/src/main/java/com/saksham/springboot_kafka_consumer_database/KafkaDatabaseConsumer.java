package com.saksham.springboot_kafka_consumer_database;

import com.saksham.springboot_kafka_consumer_database.entity.WikimediaData;
import com.saksham.springboot_kafka_consumer_database.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepository wikimediaDataRepository;

    @Autowired
    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String msg) {
        LOGGER.info(String.format("Message consumed --> %s", msg));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(msg);
        this.wikimediaDataRepository.save(wikimediaData);
    }
}
