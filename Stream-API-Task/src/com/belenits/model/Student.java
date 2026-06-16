package com.belenits.model;

public class Student {

    int id;
    String name;
    String course;
    double feePaid;
    boolean active;

    public Student(int id, String name, String course, double feePaid, boolean active) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.feePaid = feePaid;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getFeePaid() {
        return feePaid;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", feePaid=" + feePaid +
                ", active=" + active +
                '}';
    }
}
