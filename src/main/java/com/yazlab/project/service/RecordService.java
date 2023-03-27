package com.yazlab.project.service;

import com.yazlab.project.DTO.Request;
import com.yazlab.project.DTO.Response;
import com.yazlab.project.model.Sentence;
import com.yazlab.project.repository.RecordRepository;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Response save_database(Request request){
        Sentence record= new Sentence();
        System.out.println(request.getSentences());
        record.setSentences(request.getSentences());
        record.setResponse_sentence("gul");
        recordRepository.save(record);

        return new Response("gulll");
    }
}
