package kz.kaisar.springcrudapp03.dao;

import kz.kaisar.springcrudapp03.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Person #1", 21, "person1@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Person #2", 22, "person2@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Person #3", 23, "person3@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Person #4", 24, "person4@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
