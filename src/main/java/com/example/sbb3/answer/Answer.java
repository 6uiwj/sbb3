package com.example.sbb3.answer;

import com.example.sbb3.question.Question;
import com.example.sbb3.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //foreign key 관계 설정
    @ManyToOne //하나의 질문에 여러개의 답변(답변 엔티티의 question 속성과 Question 엔티티와의 관계)
    private Question question;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    Set<SiteUser> votre;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
}
