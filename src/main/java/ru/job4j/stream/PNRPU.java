package ru.job4j.stream;

public class PNRPU {
    public static void main(String[] args) {
        StudentPNRPU student = new StudentPNRPU.Builder()
                .buildName("Sergei")
                .buildSurname("Aleksandrov")
                .buildGender("Male")
                .buildGroup("Ome - 20 - 1m")
                .buildGradeBookNumber("111 - 20 - СФ")
                .buildYearOfStudy(1)
                .buildIsStudy(true)
                .buildIsLiableForService(true)
                .build();
        System.out.println(student);
    }
}
