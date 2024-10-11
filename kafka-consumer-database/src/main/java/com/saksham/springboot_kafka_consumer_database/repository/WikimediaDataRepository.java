package com.saksham.springboot_kafka_consumer_database.repository;

import com.saksham.springboot_kafka_consumer_database.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
