package com.belenits.service;

import com.belenits.model.InterviewFeedback;
import com.belenits.util.FeedbackFunctions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeedbackAnalyzer {

    public void generateReport(List<InterviewFeedback> students) {

        System.out.println("========== STUDENT REPORT ==========");

        students.forEach(student -> {

            double overall =
                    FeedbackFunctions.overallRating.apply(student);

            String performance =
                    FeedbackFunctions.performanceStatus.apply(overall);

            boolean eligible =
                    FeedbackFunctions.placementEligible.test(student);

            System.out.println("------------------------------------");
            System.out.println("Student : " + student.getStudentName());
            System.out.printf("Overall Rating : %.2f%n", overall);
            System.out.println("Performance : " + performance);
            System.out.println("Placement Eligible : "
                    + (eligible ? "Yes" : "No"));

            FeedbackFunctions.suggestions.accept(student);
        });

        groupByPerformance(students);

        sortByOverallRating(students);

        printNonEligibleStudents(students);
    }

    private void groupByPerformance(List<InterviewFeedback> students) {

        System.out.println("\n===== GROUPED BY PERFORMANCE =====");

        Map<String, List<InterviewFeedback>> grouped =
                students.stream()
                        .collect(Collectors.groupingBy(
                                student ->
                                        FeedbackFunctions.performanceStatus
                                                .apply(
                                                        FeedbackFunctions
                                                                .overallRating
                                                                .apply(student)
                                                )
                        ));

        grouped.forEach((status, list) -> {

            System.out.println(status + " :");

            list.forEach(student ->
                    System.out.println("  "
                            + student.getStudentName()));
        });
    }

    private void sortByOverallRating(List<InterviewFeedback> students) {

        System.out.println("\n===== SORTED BY OVERALL RATING =====");

        students.stream()
                .sorted(
                        Comparator.comparing(
                                        FeedbackFunctions.overallRating)
                                .reversed()
                )
                .forEach(student ->
                        System.out.printf("%s -> %.2f%n",
                                student.getStudentName(),
                                FeedbackFunctions
                                        .overallRating
                                        .apply(student)));
    }

    private void printNonEligibleStudents(
            List<InterviewFeedback> students) {

        System.out.println("\n===== NON ELIGIBLE STUDENTS =====");

        students.stream()
                .filter(
                        FeedbackFunctions
                                .placementEligible
                                .negate())
                .forEach(student -> {

                    System.out.println(
                            student.getStudentName());

                    FeedbackFunctions
                            .suggestions
                            .accept(student);
                });
    }
}
