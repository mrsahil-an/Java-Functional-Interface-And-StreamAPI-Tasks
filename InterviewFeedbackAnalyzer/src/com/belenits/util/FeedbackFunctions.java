package com.belenits.util;

import com.belenits.model.InterviewFeedback;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FeedbackFunctions {

    // Overall Rating Calculation
    public static Function<InterviewFeedback, Double> overallRating =
            feedback ->
                    (feedback.getTechnicalRating()
                            + feedback.getCommunicationRating()
                            + feedback.getCodingRating()
                            + feedback.getConfidenceRating()
                            + feedback.getProblemSolvingRating())
                            / 5;

    // Performance Status
    public static Function<Double, String> performanceStatus =
            rating -> {
                if (rating >= 8)
                    return "Excellent";
                else if (rating >= 6)
                    return "Good";
                else if (rating >= 4)
                    return "Average";
                else
                    return "Needs Improvement";
            };

    // Placement Eligibility
    public static Predicate<InterviewFeedback> placementEligible =
            feedback ->
                    overallRating.apply(feedback) >= 6
                            && feedback.getCodingRating() >= 6;

    // Improvement Suggestions
    public static Consumer<InterviewFeedback> suggestions =
            feedback -> {

                StringBuilder sb = new StringBuilder();

                if (feedback.getCommunicationRating() < 6) {
                    sb.append("Improve communication skills, ");
                }

                if (feedback.getCodingRating() < 6) {
                    sb.append("Practice coding problems, ");
                }

                if (feedback.getTechnicalRating() < 6) {
                    sb.append("Strengthen technical fundamentals, ");
                }

                if (feedback.getProblemSolvingRating() < 6) {
                    sb.append("Improve problem-solving approach, ");
                }

                if (feedback.getConfidenceRating() < 6) {
                    sb.append("Build interview confidence, ");
                }

                if (sb.length() == 0) {
                    sb.append("No major improvements required");
                }

                System.out.println("Suggestions: " +
                        sb.toString().replaceAll(", $", ""));
            };
}
