package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Sergei");
        student.setSurName("Aleksandrov");
        student.setPatronymic("Alexandrovich");
        student.setGroup("OPP-20-1m");
        student.setAdmission(new Date());

        System.out.println("Student: " + student.getSurName() + " "
                + student.getName() + " " + student.getPatronymic()
                    + "\n" + "Group: " + student.getGroup()
                        + "\n" + "Date of admission: " + student.getAdmission());
    }
}
