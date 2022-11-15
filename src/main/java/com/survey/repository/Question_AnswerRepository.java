package com.survey.repository;

import com.survey.model.Question_Answer;
import com.survey.model.Survey_Table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Question_AnswerRepository extends JpaRepository<Question_Answer, Long> {
    Page<Question_Answer> findAll(Pageable pageable);
}