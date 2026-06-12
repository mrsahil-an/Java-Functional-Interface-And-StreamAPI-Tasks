package com.belenits.service;

import com.belenits.model.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PlacementService {

    public void generatePlacementReport(List<Student> students) {

        Predicate<Student> graduationRule =
                student -> student.getGraduationYear() >= 2022;

        Predicate<Student> percentageRule =
                student -> student.getPercentage() >= 60;

        Predicate<Student> backlogRule =
                student -> student.getBacklogs() == 0;

        Predicate<Student> mockRatingRule =
                student -> student.getMockRating() >= 4;

        Predicate<Student> resumeRule =
                Student::getResumeAvailable;

        Predicate<Student> feeRule =
                Student::getFeePaid;

        Predicate<Student> skillRule =
                student -> student.getSkills().contains("Java")
                        || student.getSkills().contains("Python");

        Predicate<Student> eligibilityRule =
                graduationRule
                        .and(percentageRule)
                        .and(backlogRule)
                        .and(mockRatingRule)
                        .and(resumeRule)
                        .and(feeRule)
                        .and(skillRule);

        List<Student> eligibleStudents = new ArrayList<>();
        List<Student> rejectedStudents = new ArrayList<>();

        for (Student student : students) {

            if (eligibilityRule.test(student)) {
                eligibleStudents.add(student);
            } else {
                rejectedStudents.add(student);
            }
        }

        Comparator<Student> ratingComparator =
                (s1, s2) -> Double.compare(
                        s2.getMockRating(),
                        s1.getMockRating());

        eligibleStudents.sort(ratingComparator);

        Function<Student, String> rejectionReasonFunction =
                student -> {

                    List<String> reasons = new ArrayList<>();

                    if (!graduationRule.test(student)) {
                        reasons.add("Graduation year below 2022");
                    }

                    if (!percentageRule.test(student)) {
                        reasons.add("Percentage below 60");
                    }

                    if (!backlogRule.test(student)) {
                        reasons.add("Backlogs available");
                    }

                    if (!mockRatingRule.test(student)) {
                        reasons.add("Mock rating below 4");
                    }

                    if (!resumeRule.test(student)) {
                        reasons.add("Resume missing");
                    }

                    if (!feeRule.test(student)) {
                        reasons.add("Fee not paid");
                    }

                    if (!skillRule.test(student)) {
                        reasons.add("Java/Python skill missing");
                    }

                    return String.join(", ", reasons);
                };

        Consumer<Student> eligibleConsumer =
                student -> System.out.println(
                        student.getStudentName()
                                + " - "
                                + student.getCourseName()
                                + " - Rating: "
                                + student.getMockRating());

        System.out.println("\nEligible Students for Placement:");

        for (Student student : eligibleStudents) {

            System.out.print(student.getStudentId() + " ");
            eligibleConsumer.accept(student);
        }

        System.out.println("\nRejected Students:");

        for (Student student : rejectedStudents) {

            System.out.println(
                    student.getStudentName()
                            + " - Reason: "
                            + rejectionReasonFunction.apply(student));
        }
    }
}