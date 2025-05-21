package ru.kovalev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.kovalev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Alex", 23, "a.con@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alice", 20, "my.girlfriend@yahoo.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Gay", 22, "kuzhman@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 45, "mike.vazovsky@tochka.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }


    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(people -> people.getId() == id);
    }
}
