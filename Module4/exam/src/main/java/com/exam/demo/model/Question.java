package com.exam.demo.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "input this")
    @Size(min = 5,max = 100,message = "5-100 ky tu")
    private String title;

    @Column(name = "question")
    @NotNull(message = "input this")
    @Size(min = 10,max = 500,message = "10-500 ky tu")
    private String questionQ;

//    @Size(min = 10,max = 500,message = "10-500 ky tu")
    private String answer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_create", columnDefinition = "DATE")
    private LocalDate dateCreate;

    @Column(columnDefinition = "INT default 1")
    private Boolean status;

    @ManyToOne(targetEntity = QuestionType.class)
    @JoinColumn(name = "questionTypeId")
    private QuestionType questionType;

    public Question() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionQ() {
        return questionQ;
    }

    public void setQuestionQ(String question) {
        this.questionQ = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
