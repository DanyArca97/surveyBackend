package com.survey.model;

import javax.persistence.*;
import java.io.Serializable;
@IdClass(SurveyCompositionPK.class)
@Entity
@Table(name="survey_composition")
public class Survey_Composition {
    @Id
    @Column(name = "id_survey", unique=true)
    private long id_survey;

    @Id
    @Column(name = "id_question_answer", unique=true)
    private long id_question_answer;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_survey", nullable = false, insertable = false, updatable = false)
    private Survey_Table survey;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_question_answer", nullable = false, insertable = false, updatable = false)
    private Question_Answer question_answer;

    public Survey_Composition() {
    }

    public Survey_Composition(long id_survey, long id_question_answer) {
        this.id_survey = id_survey;
        this.id_question_answer = id_question_answer;
    }

    public long getId_survey() {
        return id_survey;
    }

    public void setId_survey(long id_survey) {
        this.id_survey = id_survey;
    }

    public long getId_question_answer() {
        return id_question_answer;
    }

    public void setId_question_answer(long id_question_answer) {
        this.id_question_answer = id_question_answer;
    }

    /*public Survey_Table getSurvey_table() {
        return survey;
    }*/

    public void setSurvey_table(Survey_Table survey_table) {
        this.survey = survey_table;
    }

    public Question_Answer getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(Question_Answer question_answer) {
        this.question_answer = question_answer;
    }
}
class SurveyCompositionPK implements Serializable{
    private long id_survey;
    private long id_question_answer;

    public SurveyCompositionPK() {

    }

    public SurveyCompositionPK(long id_survey, long id_question_answer) {
        this.id_survey = id_survey;
        this.id_question_answer = id_question_answer;
    }
}
