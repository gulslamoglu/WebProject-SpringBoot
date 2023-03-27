package com.yazlab.project.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Sentence {
    @Id
    private String record_id;

    private ArrayList<String> sentences;

    private String response_sentence;

    private Long elapsed_time;

}
