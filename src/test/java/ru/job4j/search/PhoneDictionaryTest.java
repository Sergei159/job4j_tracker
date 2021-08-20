package ru.job4j.search;


import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.hamcrest.collection.IsEmptyCollection;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Petr", "Sokolov", "5732468", "Moscow")
        );
        phones.add(
                new Person("Sergei", "Andreev", "89082766060", "Perm")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getName(), is("Petr"));
        assertThat(persons.get(1).getName(), is("Petr"));
    }

    @Test
    public void whenIsNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Sergei", "Andreev", "89082766060", "Perm")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons, is(IsEmptyCollection.empty()));
    }
}
