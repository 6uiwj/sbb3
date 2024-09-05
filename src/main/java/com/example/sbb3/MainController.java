package com.example.sbb3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb") //요청된 URL(/sbb)과 매핑
    @ResponseBody //URL 요청에 대한 응답으로 문자열을 리턴
    public String index(){
        System.out.println("index");//콘솔에 찍히는 결과
        return "sbb에 오신 것을 환영합니다."; //응답의 결과
    }
}
