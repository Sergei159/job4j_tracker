package ru.job4j.stream;

public class StudentPNRPU {
    private String name;
    private String surname;
    private String gender;
    private String group;
    private String gradeBookNumber;
    private int yearOfsStudy;
    private boolean isStudy;
    private boolean isLiableForService;

    static class Builder {
        private String name;
        private String surname;
        private String gender;
        private String group;
        private String gradeBookNumber;
        private int yearOfsStudy;
        private boolean isStudy;
        private boolean isLiableForService;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildGroup(String group) {
            this.group = group;
            return this;
        }

        Builder buildGradeBookNumber(String gradeBookNumber) {
            this.gradeBookNumber = gradeBookNumber;
            return this;
        }

        Builder buildYearOfStudy(int yearOfsStudy) {
            this.yearOfsStudy = yearOfsStudy;
            return this;
        }

        Builder buildIsStudy(boolean isStudy) {
            this.isStudy = isStudy;
            return this;
        }

        Builder buildIsLiableForService(boolean isLiableForService) {
            this.isLiableForService = isLiableForService;
            return this;
        }

        StudentPNRPU build() {
            StudentPNRPU student = new StudentPNRPU();
            student.name = name;
            student.surname = surname;
            student.gender = gender;
            student.group = group;
            student.gradeBookNumber = gradeBookNumber;
            student.yearOfsStudy = yearOfsStudy;
            student.isStudy = isStudy;
            student.isLiableForService = isLiableForService;
            return student;
        }
    }

    @Override
    public String toString() {
        return "{"
                + "Name: '" + name + '\''
                + "; Surname: " + surname + '\''
                + "; Gender: '" + gender + '\''
                + "; Group: " + group
                + "; Grade book number: '" + gradeBookNumber + '\''
                + "; year of study: " + yearOfsStudy
                + "; Is study?: '" + isStudy + '\''
                + "; Is liable for military service?: " + isLiableForService
                + '}';
    }
}
