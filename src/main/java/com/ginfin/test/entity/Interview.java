package com.ginfin.test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    @Builder.Default
    Date beginningDate = new Date();
    String endDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "interviewId")
    List<Question> questions = new ArrayList<>();
}
