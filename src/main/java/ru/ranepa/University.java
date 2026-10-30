package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Person> studentsandteachers = new ArrayList<>();
    private final List<GradeBook> gradeBooks = new ArrayList<>();
    private long nextId = 1;

    public Student enroll(String name) {
        long id = nextId++;
        GradeBook book = new GradeBook(id);
        Student student = new Student(id, name, book);
        studentsandteachers.add(student);
        gradeBooks.add(book);
        return student;
    }

    public Person findById(long id) {
        for (Person person : studentsandteachers) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new IllegalArgumentException("студент не найден");
    }

    public List<Person> all() {
        return new ArrayList<>(studentsandteachers);
    }

    public void grade(long id, int grade) {
        for (GradeBook book: gradeBooks){
            if (book.getStudentId()== id ){
                book.addGrade(grade);
                return;
            }
        }
        throw new IllegalArgumentException("зачётка не найдена");
        // TODO: найти зачётку по номеру и вызвать addGrade;
        //       если зачётки нет — IllegalArgumentException.
    }

    public double average(long id) {
        for (GradeBook book : gradeBooks) {
            if (book.getStudentId() == id) {
                return book.average();
            }
        }
        throw new IllegalArgumentException("зачётка не найдена");
    }

    public Teacher getJob(String name, String subject) {
        long id = nextId++;
        Teacher teacher = new Teacher(id,name,subject);
        studentsandteachers.add(teacher);
        return teacher;
    }
    public Person findByName(String name) {
        for (Person person : studentsandteachers) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Человек с именем" + name + " не найден");
    }
}
