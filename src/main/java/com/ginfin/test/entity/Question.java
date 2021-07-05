package com.ginfin.test.entity;

import com.ginfin.test.utils.QuestionType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String text;
    QuestionType questionType;
    @Column(name = "interviewId")
    Integer fakeInterviewId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    List<UserAnswer> userAnswers = new ArrayList<>();
}
