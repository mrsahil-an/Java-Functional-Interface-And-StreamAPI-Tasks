package com.belenits.model;

import java.util.List;

public class InterviewFeedback {

    private Integer studentId;
    private String studentName;
    private Double technicalRating;
    private Double communicationRating;
    private Double codingRating;
    private Double confidenceRating;
    private Double problemSolvingRating;
    private List<String> questionsAsked;
    private List<String> strengths;
    private List<String> weaknesses;

    public InterviewFeedback(Integer studentId, String studentName, Double technicalRating, Double communicationRating, Double codingRating, Double confidenceRating, Double problemSolvingRating, List<String> questionsAsked, List<String> strengths, List<String> weaknesses) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.technicalRating = technicalRating;
        this.communicationRating = communicationRating;
        this.codingRating = codingRating;
        this.confidenceRating = confidenceRating;
        this.problemSolvingRating = problemSolvingRating;
        this.questionsAsked = questionsAsked;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getTechnicalRating() {
        return technicalRating;
    }

    public void setTechnicalRating(Double technicalRating) {
        this.technicalRating = technicalRating;
    }

    public Double getCommunicationRating() {
        return communicationRating;
    }

    public void setCommunicationRating(Double communicationRating) {
        this.communicationRating = communicationRating;
    }

    public Double getCodingRating() {
        return codingRating;
    }

    public void setCodingRating(Double codingRating) {
        this.codingRating = codingRating;
    }

    public Double getConfidenceRating() {
        return confidenceRating;
    }

    public void setConfidenceRating(Double confidenceRating) {
        this.confidenceRating = confidenceRating;
    }

    public Double getProblemSolvingRating() {
        return problemSolvingRating;
    }

    public void setProblemSolvingRating(Double problemSolvingRating) {
        this.problemSolvingRating = problemSolvingRating;
    }

    public List<String> getQuestionsAsked() {
        return questionsAsked;
    }

    public void setQuestionsAsked(List<String> questionsAsked) {
        this.questionsAsked = questionsAsked;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }
}
