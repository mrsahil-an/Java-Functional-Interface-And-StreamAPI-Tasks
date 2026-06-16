package com.belenits.runners;

import com.belenits.model.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(101, "Raju", "Java", 15000, true),
                new Student(102, "Rani", "Python", 0, false),
                new Student(103, "Kiran", "Java", 10000, true),
                new Student(104, "Anil", "DevOps", 0, false),
                new Student(105, "Suresh", "Python", 20000, true),
                new Student(106, "Mahesh", "Java", 0, true)
        );

        /*
         * ###### Requirement :: Develop a project to display all this information using stream API
         *
         * ** Print Active students
         *
         * ** Print Paid Students
         *
         * ** Print Java Students
         *
         * ** Print Student Names
         *
         * ** Print Total Fee Collected
         *
         * ** Print Count of unpaid students
         *
         * ** Group students by Course and print
         *
         * ** Print Highest fee paid student
         *
         * ** Print Top 3 Fee paid students
         * */

        //  Print Active students
        students.stream()
                .filter(Student::isActive)
                .forEach(System.out::println);
        System.out.println("================================================================");

        // Print Paid Students
        students.stream()
                .filter(student -> student.getFeePaid()!=0)
                .forEach(System.out::println);
        System.out.println("================================================================");

        // Print Java Students
        students.stream()
                .filter(student -> student.getCourse().equalsIgnoreCase("JAVA"))
                .forEach(System.out::println);
        System.out.println("================================================================");

        // Print Student Names
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);
        System.out.println("================================================================");

        // Print Total Fee Collected
        double totalFees = students.stream()
                                    .mapToDouble(Student::getFeePaid)
                                    .sum();
        System.out.println("Student total fees : " + totalFees);
        System.out.println("================================================================");

        // Print Count of unpaid students
        long totalUnpaidStudent = students.stream()
                                            .filter(student -> student.getFeePaid() == 0)
                                            .count();
        System.out.println("Total unpaid student : " + totalUnpaidStudent);
        System.out.println("================================================================");

        // Group students by Course and print
        students.stream()
                .collect(Collectors.groupingBy(Student::getCourse))
                .forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("================================================================");

        // Print Highest fee paid student
        Optional<Student> student = students.stream()
                                            .sorted(Comparator.comparing(Student::getFeePaid).reversed())
                                                    .limit(1)
                                                            .findFirst();
        System.out.println(student);
        System.out.println("================================================================");

        // Print Top 3 Fee paid students
        students.stream()
                .sorted(Comparator.comparing(Student::getFeePaid).reversed())
                .limit(3)
                .toList()
                .forEach(System.out::println);

    }
}
