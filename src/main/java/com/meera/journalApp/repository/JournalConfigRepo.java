package com.meera.journalApp.repository;

import com.meera.journalApp.entity.JournalConfig;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalConfigRepo extends MongoRepository<JournalConfig, ObjectId> {
}
