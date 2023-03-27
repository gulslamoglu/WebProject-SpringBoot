package com.yazlab.project.repository;

import com.yazlab.project.model.Sentence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Sentence, String> {


}
