package com.ginfin.test.controller;

import com.ginfin.test.entity.Interview;
import com.ginfin.test.entity.UserAnswer;
import com.ginfin.test.entity.UserId;
import com.ginfin.test.repository.InterviewRepository;
import com.ginfin.test.repository.QuestionRepository;
import com.ginfin.test.repository.UserAnswerRepository;
import com.ginfin.test.repository.UserIdRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserAnswerRepository userAnswerRepository;
    private final UserIdRepository userIdRepository;
    private final InterviewRepository interviewRepository;
    private final QuestionRepository questionRepository;
    @GetMapping("/getAllInterview")
    public List<Interview> getAllPolls(){
      return   interviewRepository.findAll();
    }
    @PostMapping("/addAnswer")
    public Integer addAnswer(Integer userId,String answer,Integer questionId){
        if(!userIdRepository.existsById(userId)){
            userIdRepository.save(UserId.builder().id(userId).build());
        }
        val question =questionRepository.findById(questionId).get();
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserAnswer(answer);
        userAnswer.setUserId(userId);
        question.getUserAnswers().add(userAnswer);
        questionRepository.save(question);
        return userAnswerRepository.findFirstByOrderByIdDesc().getId();
    }
@GetMapping("/getUserAnswer")
    public List<UserAnswer> getUserAnswer(Integer userId){
       return userAnswerRepository.findAllByUserId(userId);

}
}
