package ru.ranepa;

public class Teacher extends Person {
    private String subject;
    public Teacher ( long id , String name, String subject){
        super(id , name);
        this.subject = subject;
    }
    public String getSubject(){
        return subject;
    }

    @Override
    public String report() {
        return "Преподаватель " + getName() + " (№" + getId() + "): предмет " + subject;
    }
}
