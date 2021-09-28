package ru.job4j.stream;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
       return stream.map(Pupil::getSubjects)
                .flatMap(Collection::stream)
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(
                            pupil.getName(),
                            Stream.of(pupil.getSubjects())
                                .flatMap(Collection::stream)
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0D)
                            ))
                        .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
       Map<String, Double> intermedia = stream.map(Pupil::getSubjects)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)
                        ));
        List<Tuple> rsl = intermedia.entrySet().stream()
               .map(s -> new Tuple(
                       s.getKey(),
                       s.getValue()
               ))
               .collect(Collectors.toList());
        return rsl;
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return (Tuple) stream.map(pupil -> new Tuple(
                        pupil.getName(),
                        Stream.of(pupil.getSubjects())
                                .flatMap(Collection::stream)
                                .mapToInt(Subject::getScore)
                                .max()
                                .orElse(0)
                ));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}