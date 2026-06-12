package com.belenits.model;

import java.time.LocalDate;

public class Student {

    private int studentId;
    private String studentName;
    private LocalDate admissionDate;

    public Student(int studentId, String studentName, LocalDate admissionDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.admissionDate = admissionDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    @Override
    public String toString() {
        return studentName;
    }
}
