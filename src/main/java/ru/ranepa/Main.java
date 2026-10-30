package ru.ranepa;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        Student anna = university.enroll("Анна");
        Teacher viktor = university.getJob("Виктор", "история");
        Student boris = university.enroll("Борис");
        university.grade(anna.getId(), 4);
        university.grade(anna.getId(), 5);
        university.grade(anna.getId(), 3);
        System.out.println(anna.report());
        for (Person person : university.all()) {
            System.out.println(person.report());
        }
        try {
            university.grade(viktor.getId(), 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }
        try {
            Person found = university.findByName("Виктор");
            System.out.println("Найден: " + found.report());
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }

        try {
            university.findByName("Иван");
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }
        System.out.println(university.average(anna.getId()));
        // TODO: сценарий
        // 1. принять преподавателя
        // 2. поставить Анне оценки
        // 3. напечатать всех одним циклом
        // 4. попробовать оценить преподавателя — отказ
        // 5. найти человека по имени
        // 6. напечатать средний балл
    }
}
