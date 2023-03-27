package com.yazlab.project.service;

import com.yazlab.project.DTO.Request;
import com.yazlab.project.DTO.Response;
import com.yazlab.project.model.Sentence;
import com.yazlab.project.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final algoritma alg;

    public RecordService(RecordRepository recordRepository, algoritma alg) {
        this.recordRepository = recordRepository;
        this.alg = alg;
    }

    public Response output(Request request) {
        Long first_time=alg.startTime();
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> array = request.getSentences();
        temp.add(array.get(0));

        for (int i = 0; i < array.size()-1; i++) {//
            String out = alg.commonWords(array.get(i), array.get(i + 1));
            temp.add(alg.merge(array.get(i), array.get(i + 1), out));

        }
        String out_sentence = "";
        for (int i = 0; i < array.size(); i++) {
            out_sentence += temp.get(i);
        }
        Long finish_time=alg.finishTime();
        Sentence record= new Sentence();
        record.setSentences(request.getSentences());
        record.setResponse_sentence(out_sentence);
        record.setElapsed_time(finish_time-first_time);
        recordRepository.save(record);

        return new Response(out_sentence,finish_time-first_time);

    }
}
