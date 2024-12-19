package com.nan.Quiz.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String questionTitle;
    private String category;

}
