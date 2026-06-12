package com.belenits.service;

import com.belenits.model.Course;
import com.belenits.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentService {

    private final Predicate<Student> knowsJava =
            student -> student.getSkills()
                    .stream()
                    .anyMatch(skill -> skill.equalsIgnoreCase("Java"));

    private final Predicate<Student> knowsPython =
            student -> student.getSkills()
                    .stream()
                    .anyMatch(skill -> skill.equalsIgnoreCase("Python"));

    private final Predicate<Student> lowBudget =
            student -> student.getBudget() < 20000;

    private final Predicate<Student> fresher =
            student -> student.getExperience() == 0;

    private final Predicate<Student> experienced =
            student -> student.getExperience() >= 3;

    private final Comparator<Course> sortByRatingDesc =
            Comparator.comparing(Course::getRating).reversed();

    private final Consumer<Course> displayCourse =
            course -> System.out.println(
                    course.getCourseId() + " " +
                    course.getCourseName()
                            + " - Rs. " + course.getFee()
                            + " - Rating: " + course.getRating()
            );

    public final Function<Student, List<Course>> recommendCourses = student -> {

        List<Course> courses = new ArrayList<>();

        // Java recommendations
        if (knowsJava.test(student)) {

            courses.add(new Course(
                    101,
                    "Java Fullstack",
                    "Java",
                    "Advanced",
                    25000.0,
                    "6 Months",
                    4.8));

            courses.add(new Course(
                    102,
                    "Spring Boot Microservices",
                    "Java",
                    "Intermediate",
                    18000.0,
                    "4 Months",
                    4.7));
        }

        // Python recommendations
        if (knowsPython.test(student)) {

            courses.add(new Course(
                    201,
                    "Python Fullstack",
                    "Python",
                    "Intermediate",
                    22000.0,
                    "5 Months",
                    4.6));

            courses.add(new Course(
                    202,
                    "Data Science with Python",
                    "Python",
                    "Advanced",
                    19000.0,
                    "6 Months",
                    4.9));
        }

        // Budget filter
        if (lowBudget.test(student)) {
            courses = courses.stream()
                    .filter(course -> course.getFee() < 20000)
                    .collect(Collectors.toList());
        }

        // Fresher -> Beginner courses
        if (fresher.test(student)) {
            courses = courses.stream()
                    .filter(course ->
                            course.getLevel().equalsIgnoreCase("Beginner")
                                    || course.getLevel().equalsIgnoreCase("Intermediate"))
                    .collect(Collectors.toList());
        }

        // Experienced -> Advanced courses
        if (experienced.test(student)) {
            courses = courses.stream()
                    .filter(course ->
                            course.getLevel().equalsIgnoreCase("Advanced")
                                    || course.getLevel().equalsIgnoreCase("Intermediate"))
                    .collect(Collectors.toList());
        }

        return courses.stream()
                .sorted(sortByRatingDesc)
                .collect(Collectors.toList());
    };

    public void printRecommendations(Student student) {

        System.out.println("Recommended Courses for "
                + student.getStudentName() + ":");

        List<Course> courses = recommendCourses.apply(student);

        for (Course course : courses) {
            displayCourse.accept(course);
        }
    }

}