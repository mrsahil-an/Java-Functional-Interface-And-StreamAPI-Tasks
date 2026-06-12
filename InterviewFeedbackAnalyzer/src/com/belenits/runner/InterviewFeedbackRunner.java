package com.belenits.runner;

import com.belenits.model.InterviewFeedback;
import com.belenits.service.FeedbackAnalyzer;

import java.util.Arrays;
import java.util.List;

public class InterviewFeedbackRunner {

    public static void main(String[] args) {

        InterviewFeedback ravi =
                new InterviewFeedback(
                        101,
                        "Ravi",
                        8.0,
                        6.0,
                        8.0,
                        8.0,
                        9.0,
                        Arrays.asList(
                                "Java",
                                "Streams",
                                "OOP"),
                        Arrays.asList(
                                "Coding",
                                "Problem Solving"),
                        Arrays.asList(
                                "Communication")
                );

        InterviewFeedback priya =
                new InterviewFeedback(
                        102,
                        "Priya",
                        5.0,
                        4.0,
                        5.0,
                        5.0,
                        6.0,
                        Arrays.asList(
                                "Collections",
                                "SQL"),
                        Arrays.asList(
                                "Confidence"),
                        Arrays.asList(
                                "Coding")
                );

        InterviewFeedback arjun =
                new InterviewFeedback(
                        103,
                        "Arjun",
                        9.0,
                        9.0,
                        9.0,
                        8.0,
                        8.0,
                        Arrays.asList(
                                "Spring",
                                "Microservices"),
                        Arrays.asList(
                                "Leadership"),
                        Arrays.asList()
                );

        List<InterviewFeedback> students =
                Arrays.asList(ravi, priya, arjun);

        FeedbackAnalyzer analyzer =
                new FeedbackAnalyzer();

        analyzer.generateReport(students);
    }
}
