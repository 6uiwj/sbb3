package com.example.sbb3.answer;

import com.example.sbb3.question.Question;
import com.example.sbb3.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final QuestionService questionService;
    @PostMapping("/create/{id}")
    public String createAnswer(@PathVariable("id") Integer id, Model model) {
        Question question = this.questionService.getQuestion(id);
        //저장
        return String.format("redirect:/question/detail/%s",id);
    }
}
