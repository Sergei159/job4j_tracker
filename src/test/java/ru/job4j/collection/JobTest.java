package ru.job4j.collection;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenDescCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority
                = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority
                = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscByName() {
        List<Job> ascName = new ArrayList<>(
                Arrays.asList(
                        new Job("Andrei", 1),
                        new Job("George", 2),
                        new Job("Alexei", 3),
                        new Job("Alex", 4),
                        new Job("Mulat", 5)
                ));
        Collections.sort(ascName, new JobAscByName());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Alex", 4),
                        new Job("Alexei", 3),
                        new Job("Andrei", 1),
                        new Job("George", 2),
                        new Job("Mulat", 5)
                ));
        assertThat(ascName, is(expected));
    }

    @Test
    public void whenDescName() {
        List<Job> descName = new ArrayList<>(
                Arrays.asList(
                        new Job("Andrei", 1),
                        new Job("George", 2),
                        new Job("Alexei", 3),
                        new Job("Alex", 4),
                        new Job("Mulat", 5)
                ));
        Collections.sort(descName, new JobDescByName());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Mulat", 5),
                        new Job("George", 2),
                        new Job("Andrei", 1),
                        new Job("Alexei", 3),
                        new Job("Alex", 4)
                ));
        assertThat(descName, is(expected));
    }

    @Test
    public void whenAscPriority() {
        List<Job> ascPriority = new ArrayList<>(
                Arrays.asList(
                        new Job("Andrei", 1),
                        new Job("George", 2),
                        new Job("Alexei", 3),
                        new Job("Alex", 4),
                        new Job("Mulat", 5)
                ));
        Collections.sort(ascPriority, new JobAscByPriority());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Andrei", 1),
                        new Job("George", 2),
                        new Job("Alexei", 3),
                        new Job("Alex", 4),
                        new Job("Mulat", 5)
                ));
        assertThat(ascPriority, is(expected));
    }

    @Test
    public void whenDescOrder() {
        List<Job> descOrder = new ArrayList<>(
                Arrays.asList(
                        new Job("Andrei", 1),
                        new Job("George", 2),
                        new Job("Alexei", 3),
                        new Job("Alex", 4),
                        new Job("Mulat", 5)
                ));
        Collections.sort(descOrder, new JobDescByPriority());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Mulat", 5),
                        new Job("Alex", 4),
                        new Job("Alexei", 3),
                        new Job("George", 2),
                        new Job("Andrei", 1)
                ));
        assertThat(descOrder, is(expected));
    }

}