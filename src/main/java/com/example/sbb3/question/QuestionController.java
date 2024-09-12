package com.example.sbb3.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionRepository questionRepository;
    @GetMapping("/list")
    public String list(Integer id, Model model) {
        List<Question> questionList= questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
