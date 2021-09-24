package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> hasName = (p) -> p.getName().contains(key);
        Predicate<Person> hasSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> hasPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> hasAdress = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = hasName.or(hasSurname).or(hasPhone).or(hasAdress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
