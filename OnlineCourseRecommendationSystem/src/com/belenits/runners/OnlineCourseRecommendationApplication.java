package com.belenits.runners;

import com.belenits.model.Student;
import com.belenits.service.StudentService;

import java.util.List;

public class OnlineCourseRecommendationApplication {
    public static void main(String[] args) {

        Student student = new Student(
                1,
                "Suresh",
                "B.Tech",
                List.of("Java"),
                3,
                "Full Stack",
                20000.0
        );

        StudentService service = new StudentService();
        service.printRecommendations(student);
        System.out.println();

        Student student2 = new Student(
                2,
                "John",
                "B.S.C",
                List.of("Python"),
                1,
                "Data Science",
                25000.0
        );
        service.printRecommendations(student2);
        System.out.println();

    }
}
