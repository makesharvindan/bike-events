package com.global.bike.events.repo;

import com.global.bike.events.entity.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepo extends MongoRepository<Sale, String> {

}
