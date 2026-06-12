package com.belenits.runner;

import com.belenits.model.*;
import com.belenits.service.ReportService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReportApplication {

    public static void main(String[] args) {

        Student s1 = new Student(101, "Rahul",
                LocalDate.of(2025, 1, 15));

        Student s2 = new Student(102, "Priya",
                LocalDate.of(2025, 1, 20));

        Student s3 = new Student(103, "Kiran",
                LocalDate.of(2025, 2, 10));

        Student s4 = new Student(104, "Sneha",
                LocalDate.of(2025, 3, 5));

        List<Student> students =
                Arrays.asList(s1, s2, s3, s4);

        Course java = new Course(
                1,
                "Java Fullstack",
                "Ramesh",
                75000);

        Course python = new Course(
                2,
                "Python Fullstack",
                "Suresh",
                70000);

        Course devops = new Course(
                3,
                "DevOps",
                "Ramesh",
                65000);

        Course ds = new Course(
                4,
                "Data Science",
                "Mahesh",
                90000);

        Course aws = new Course(
                5,
                "AWS Cloud",
                "Suresh",
                85000);

        List<Course> courses =
                Arrays.asList(java, python, devops, ds, aws);

        List<Enrollment> enrollments =
                Arrays.asList(
                        new Enrollment(s1, java),
                        new Enrollment(s2, java),
                        new Enrollment(s3, python),
                        new Enrollment(s4, ds),
                        new Enrollment(s1, devops),
                        new Enrollment(s2, aws)
                );

        List<Payment> payments =
                Arrays.asList(
                        new Payment(1, s1, 75000, true),
                        new Payment(2, s2, 70000, true),
                        new Payment(3, s3, 65000, false),
                        new Payment(4, s4, 90000, true),
                        new Payment(5, s1, 85000, false)
                );

        System.out.println(
                ReportService.reportHeader.get());

        System.out.println("Course Wise Enrollment Report");

        Map<String, Long> enrollmentReport =
                ReportService.courseWiseEnrollmentReport
                        .generate(enrollments);

        enrollmentReport.forEach(
                (course, count) ->
                        System.out.printf(
                                "%-20s : %d Students%n",
                                course,
                                count
                        )
        );

        double revenue =
                ReportService.totalRevenueReport
                        .generate(payments);

        System.out.println("\nTotal Revenue : ₹" + revenue);

        double pending =
                ReportService.pendingPaymentReport
                        .generate(payments);

        System.out.println(
                "Pending Payments : ₹" + pending);

        System.out.println("\nTrainer Wise Course Report");

        ReportService.trainerWiseCourseReport
                .generate(courses)
                .forEach(
                        (trainer, courseList) ->
                                System.out.println(
                                        trainer + " -> " + courseList
                                )
                );

        System.out.println("\nMonthly Admission Report");

        ReportService.monthlyAdmissionReport
                .generate(students)
                .forEach(
                        (month, count) ->
                                System.out.println(
                                        month + " -> " + count
                                )
                );

        System.out.println("\nTop 5 High Fee Courses");

        ReportService.top5HighFeeCoursesReport
                .generate(courses)
                .forEach(
                        c -> System.out.println(
                                c.getCourseName()
                                        + " - ₹"
                                        + c.getFee()
                        )
                );
    }
}