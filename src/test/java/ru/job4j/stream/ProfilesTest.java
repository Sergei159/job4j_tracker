package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenEqualAddresses() {
        List<Address> list = Arrays.asList(
                new Address("Perm", "Lenina", 3, 59),
                new Address("Perm", "Elkina", 7, 25),
                new Address("Moscow", "Lenina", 1, 22)
        );
        List<Profile> expected = Arrays.asList(
                new Profile(list.get(0)),
                new Profile(list.get(1)),
                new Profile(list.get(2))
        );
        assertThat(Profiles.collect(expected), is(list));
    }

}