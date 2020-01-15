package wolox.training.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wolox.training.model.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @RequestMapping("/person/{id}")
    public Person person(@PathVariable("id") int personId) {
        for (Person person: getPersons()) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }

        return null;

    }

    @RequestMapping("/persons")
    public List< Person > persons() {
        return getPersons();
    }

    public List < Person > getPersons() {

        List < Person > persons = new ArrayList< Person >();
        persons.add(new Person(1, "Yashwant", "Chavan", 35));
        persons.add(new Person(2, "Mahesh", "More", 40));
        persons.add(new Person(3, "Ganesh", "Patil", 30));

        return persons;
    }
}