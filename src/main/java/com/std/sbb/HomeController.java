package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//@COntrooler의 의미
//개발자가 스프링부트에게 말한다.
//아래에 이쓰는 GomeControoler 는 컨트롤러이다
@Controller
public class HomeController {
    int a = -1;


    @GetMapping("/home/main")
    @ResponseBody
    public String ShowMain() {
        return "안녕하세요";
    }

    //만약에 home/main 이런 요청이 오면 아래 메서드를 실행해줘
    @GetMapping("/home/increase")
    @ResponseBody
    public String ShowIncrese() {
        a++;
        return ("응답 : " + a);

    }

    @GetMapping("/home/plus")
    @ResponseBody
    public int plus(@RequestParam(value = "a", defaultValue = "0") int a, @RequestParam(value = "b", defaultValue = "0") int b) {
        return a + b;
    }

    @GetMapping("/home/minus")
    @ResponseBody
    public int minus(@RequestParam(value = "a", defaultValue = "0") int a, @RequestParam(value = "b", defaultValue = "0") int b) {
        return a - b;
    }

    @GetMapping("/home/multiply")
    @ResponseBody
    public int multipule(@RequestParam(value = "a", defaultValue = "0") int a, @RequestParam(value = "b", defaultValue = "0") int b) {
        return a * b;
    }

    @GetMapping("/home/devide")
    @ResponseBody
    public int devide(@RequestParam(value = "a", defaultValue = "0") int a, @RequestParam(value = "b", defaultValue = "0") int b) {
        return a / b;
    }

    @GetMapping("/home/returnCar")
    @ResponseBody
    public Car showReturnCar() {
        Car car = new Car();
        car.setId(2);
        car.setSpeed(200);
        car.setName("ford");
        car.setIds(new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }});
        return car;
    }

}


//전체 속성을 포함하는 생성자 함수 생성
//게터, 세터 생성
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Car {
    private int id;
    private int speed;
    private String name;
    private List<Integer> ids;
}