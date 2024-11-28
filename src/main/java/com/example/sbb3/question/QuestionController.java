package com.example.sbb3.question;

import com.example.sbb3.answer.AnswerForm;
import com.example.sbb3.user.SiteUser;
import com.example.sbb3.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private  final UserService userService;

    /**
     * 질문 목록을 조회하여 템플릿에 전달하는 메서드
     * 조회한 객체를 model에 "questionList"라는 이름으로 저장하여 템플릿에 전달
     * -> 템플릿에서 저장된 이름을 통해 (${questionList}) 출력 가능
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging",paging);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
     public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list";
     }

     @PreAuthorize("isAuthenticated()")
     @GetMapping("/modify/{id}")
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        if(!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        question.setSubject(question.getSubject());
        question.setContent(question.getContent());
        return "question_form";

     }
}
