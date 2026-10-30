package ru.ranepa;

public class Student extends Person {
    private final GradeBook grades;

    Student(long id, String name, GradeBook grades) {
        super(id, name);
        this.grades = grades;
    }

    public double average() {
        return grades.average();
    }

    public String report() {
        return "Студент " + getName() + " (№" + getId() + "): " + grades.describe();
    }
}
