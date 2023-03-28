package com.yazlab.project.controller;

import com.yazlab.project.DTO.Request;
import com.yazlab.project.DTO.Response;
import com.yazlab.project.model.Sentence;
import com.yazlab.project.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sentences")
@CrossOrigin
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService, RecordService recordService1){
        this.recordService = recordService1;
    }

    @PostMapping()
    public ResponseEntity<Response> post_req(@RequestBody Request request){

        Response response=recordService.save_db(request);

        return ResponseEntity.ok(response);
    }


}
