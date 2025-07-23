package com.std.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@COntrooler의 의미
//개발자가 스프링부트에게 말한다.
//아래에 이쓰는 GomeControoler 는 컨트롤러이다
@Controller
public class HomeController {
    //만약에 home/main 이런 요청이 오면 아래 메서드를 실행해줘
    @GetMapping("/home/main")
    @ResponseBody
    public String ShowMain() {
        return "안녕하세요";
    }
}
