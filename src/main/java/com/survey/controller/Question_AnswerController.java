package com.survey.controller;

import com.survey.model.Question_Answer;
import com.survey.model.Survey_Table;
import com.survey.repository.Question_AnswerRepository;
import com.survey.repository.Survey_TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("survey/api")
public class Question_AnswerController {

    @Autowired
    Question_AnswerRepository repository;

    @GetMapping("/question-answer")
    public ResponseEntity<List<Question_Answer>> getAllQuestionAnswer() {
        try {
            List<Question_Answer> question_answers = new ArrayList<>();

            question_answers.addAll(repository.findAll());

            if (question_answers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(question_answers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/question-answer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Question_Answer> createQuestionAnswer(@RequestBody Question_Answer qna) {
        try {
            Question_Answer newQnA = repository.save(new Question_Answer(qna.getId_question(), qna.getId_answer()));
            return new ResponseEntity<>(newQnA, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
