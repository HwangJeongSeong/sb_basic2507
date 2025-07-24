package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    int lastId;
    List<Person> people;

    PersonController () {
        lastId = 0;
        people = new ArrayList<>();
    }

    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson(@RequestParam("name") String name, @RequestParam("age") int age) {
        lastId++;
        Person p = new Person(lastId, age, name);

        people.add(p);

        return String.format("%d 번째 사람이 추가 되었습니다.", p.getId());
    }

    @GetMapping("/person/people")
    @ResponseBody
    public List<Person> getPeople() {
        System.out.println(people);
        return people;
    }
    @GetMapping("/person/remove")
    @ResponseBody
    public String removePerson(int id) {
        boolean removed = people.removeIf(person -> person.getId() == id);

        if (removed == false) {
            return id + "번 사람이 존재하지 않습니다.";
        }

        return id + "번 사람이 삭제 되었습니다.";
    }

    @GetMapping("/person/modify")
    @ResponseBody
    public String modifyPerson(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age) {
        if (id <= 0 || id > people.size()) {
            return  id + "번 사람이 존재하지 않습니다.";
        }

        Person p = people.get(id - 1);
        p.setName(name);
        p.setAge(age);

        return String.format("%d번 사람의 정보가 수정되었습니다:", p.getId());
    }
}

@AllArgsConstructor
@Getter
@Setter
@ToString
class Person {
    private int id;
    private int age;
    private String name;
}
