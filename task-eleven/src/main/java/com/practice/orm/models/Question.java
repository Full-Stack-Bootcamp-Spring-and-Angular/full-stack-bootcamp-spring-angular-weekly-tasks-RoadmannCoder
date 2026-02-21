package com.practice.orm.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String questionName;

    @OneToMany
    @JoinColumn(name = "qid")
    private List<Answer> answers;


}
