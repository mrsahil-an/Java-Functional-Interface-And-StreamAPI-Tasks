package com.belenits.runners;

import com.belenits.model.Student;
import com.belenits.service.PlacementService;

import java.util.Arrays;
import java.util.List;

public class PlacementApplication {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(

                new Student(
                        101,
                        "Ravi",
                        "Java Fullstack",
                        2023,
                        75.0,
                        0,
                        4.8,
                        Arrays.asList("Java", "Spring"),
                        true,
                        true),

                new Student(
                        102,
                        "Sneha",
                        "Python Fullstack",
                        2022,
                        82.0,
                        0,
                        4.6,
                        Arrays.asList("Python", "Django"),
                        true,
                        true),

                new Student(
                        103,
                        "Kiran",
                        "Java Fullstack",
                        2021,
                        58.0,
                        2,
                        3.5,
                        Arrays.asList("HTML"),
                        false,
                        true)
        );

        PlacementService service =
                new PlacementService();

        service.generatePlacementReport(students);
    }
}
