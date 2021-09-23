package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenEqualAddresses() {
        List<Address> list = List.of(
                new Address("Perm", "Lenina", 3, 59),
                new Address("Perm", "Elkina", 7, 25),
                new Address("Moscow", "Lenina", 1, 22)
        );
        List<Profile> expected = List.of(
                new Profile(list.get(0)),
                new Profile(list.get(1)),
                new Profile(list.get(2))
        );
        assertThat(Profiles.collect(expected), is(list));
    }

    @Test
    public void whenNoDuplicateAddresses() {
        List<Address> list = List.of(
                new Address("Perm", "Lenina", 3, 59),
                new Address("Perm", "Elkina", 7, 25),
                new Address("Perm", "Elkina", 7, 25),
                new Address("Perm", "Elkina", 7, 25),
                new Address("Moscow", "Lenina", 1, 22)
        );
        List<Profile> expected = List.of(
                new Profile(list.get(0)),
                new Profile(list.get(1)),
                new Profile(list.get(2)),
                new Profile(list.get(3)),
                new Profile(list.get(4))

        );
        assertThat(Profiles.uniqueCollect(expected), is(
                List.of(
                        list.get(4),
                        list.get(0),
                        list.get(3)
                )));
    }

}