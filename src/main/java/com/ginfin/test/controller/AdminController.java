package com.ginfin.test.controller;

import com.ginfin.test.entity.Admin;
import com.ginfin.test.entity.Interview;
import com.ginfin.test.entity.Question;
import com.ginfin.test.jwt.AuthRequest;
import com.ginfin.test.jwt.AuthResponse;
import com.ginfin.test.jwt.JwtProvider;
import com.ginfin.test.jwt.UserService;
import com.ginfin.test.repository.InterviewRepository;
import com.ginfin.test.repository.QuestionRepository;
import com.ginfin.test.utils.QuestionType;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AdminController {
    private final InterviewRepository interviewRepository;
    private final QuestionRepository questionRepository;
    private final UserService userService;

    private final JwtProvider jwtProvider;

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        Admin adminEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(adminEntity.getName());
        return new AuthResponse(token);
    }

    @PostMapping("/admin/addInterview")
    public Integer addInterview(String name, String endDate) {
        return interviewRepository.save(Interview.builder().endDate(endDate).name(name).build()).getId();

    }

    @PostMapping("/admin/changeInterviewEndDate")
    public void changeInterviewEndDate(Integer id, String endDate) {
        val interview = interviewRepository.findById(id).get();
        interview.setEndDate(endDate);
        interviewRepository.save(interview);
    }

    @PostMapping("/admin/changeInterviewName")
    public void changeInterviewName(Integer id, String name) {
        val interview = interviewRepository.findById(id).get();
        interview.setName(name);
        interviewRepository.save(interview);
    }

    @PostMapping("/admin/deleteInterview")
    public void deleteInterview(Integer id) {
        interviewRepository.deleteById(id);
    }

    @PostMapping("/admin/addQuestion")
    public Integer addQuestion(Integer interviewId, QuestionType questionType, String text) {
        val interview = interviewRepository.findById(interviewId).get();
        Question question = new Question();
        question.setText(text);
        question.setQuestionType(questionType);
        interview.getQuestions().add(question);
        interviewRepository.save(interview);
        return questionRepository.findFirstByOrderByIdDesc().getId();

    }
    @PostMapping("/admin/changeQuestionText")
    public void changeQuestionText(Integer id, String text) {
        val question = questionRepository.findById(id).get();
        question.setText(text);
        question.setFakeInterviewId(question.getFakeInterviewId());
        questionRepository.save(question);
    }

    @PostMapping("/admin/changeQuestionType")
    public void changeQuestionQuestionType(Integer id, QuestionType questionType) {
        val question = questionRepository.findById(id).get();
        question.setQuestionType(questionType);
        question.setFakeInterviewId(question.getFakeInterviewId());
        questionRepository.save(question);
    }
    @PostMapping("/admin/deleteQuestion")
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }

}
