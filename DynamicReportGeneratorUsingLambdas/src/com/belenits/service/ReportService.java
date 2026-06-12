package com.belenits.service;

import com.belenits.functional.ReportGenerator;
import com.belenits.model.Course;
import com.belenits.model.Enrollment;
import com.belenits.model.Payment;
import com.belenits.model.Student;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReportService {


    public static Predicate<Payment> pendingPayment =
            payment -> !payment.isPaid();


    public static Function<Payment, Double> amountExtractor =
            Payment::getAmount;


    public static Consumer<String> printer =
            System.out::println;


    public static Supplier<String> reportHeader =
            () -> "\n========== REPORT ==========\n";


    public static Comparator<Course> feeComparator =
            Comparator.comparingDouble(Course::getFee)
                    .reversed();


    public static ReportGenerator<Payment, Double> totalRevenueReport =
            payments -> payments.stream()
                    .filter(Payment::isPaid)
                    .map(amountExtractor)
                    .reduce(0.0, Double::sum);


    public static ReportGenerator<Payment, Double> pendingPaymentReport =
            payments -> payments.stream()
                    .filter(pendingPayment)
                    .collect(Collectors.summingDouble(Payment::getAmount));


    public static ReportGenerator<Enrollment, Map<String, Long>>
            courseWiseEnrollmentReport =
            enrollments -> enrollments.stream()
                    .collect(Collectors.groupingBy(
                            e -> e.getCourse().getCourseName(),
                            Collectors.counting()
                    ));


    public static ReportGenerator<Course, Map<String, List<String>>>
            trainerWiseCourseReport =
            courses -> courses.stream()
                    .collect(Collectors.groupingBy(
                            Course::getTrainerName,
                            Collectors.mapping(
                                    Course::getCourseName,
                                    Collectors.toList()
                            )
                    ));


    public static ReportGenerator<Student, Map<Month, Long>>
            monthlyAdmissionReport =
            students -> students.stream()
                    .collect(Collectors.groupingBy(
                            s -> s.getAdmissionDate().getMonth(),
                            Collectors.counting()
                    ));


    public static ReportGenerator<Course, List<Course>>
            top5HighFeeCoursesReport =
            courses -> courses.stream()
                    .sorted(feeComparator)
                    .limit(5)
                    .collect(Collectors.toList());
}
