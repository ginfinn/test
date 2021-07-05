package com.ginfin.test.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer userId;
    String userAnswer;
    @Column(name = "questionId")
    Integer fakeQuestionId;
}
