package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private int lastId;
    private List<Person> people;

    public PersonController() {
        lastId = 0;
        people = new ArrayList<>();
    }

    @GetMapping("/person/add")
    public String addPerson(@RequestParam("name") String name, @RequestParam("age") int age) {
        lastId++;
        Person person = new Person(lastId, age, name);
        people.add(person);

        return String.format("id.%d \n이름 : %s \n나이 : %d \n", person.getId(), person.getName(), person.getAge());
    }
}

@AllArgsConstructor
@Getter
@Setter
class Person {
    private int id;
    private int age;
    private String name;
}
