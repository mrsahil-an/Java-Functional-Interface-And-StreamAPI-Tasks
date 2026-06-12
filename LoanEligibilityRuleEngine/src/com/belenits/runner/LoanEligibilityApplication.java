package com.belenits.runner;

import com.belenits.model.Customer;
import com.belenits.service.LoanEligibilityService;

import java.util.List;

public class LoanEligibilityApplication {

    public static void main(String[] args) {

        Customer customer = new Customer(
                101,
                "Kiran",
                30,
                60000.0,
                700,
                10000.0,
                "SALARIED",
                2000000.0
        );

        LoanEligibilityService service =
                new LoanEligibilityService();

        System.out.println("Customer : "
                + customer.getCustomerName());

        if (service.isEligible(customer)) {

            System.out.println("Loan Status : APPROVED");
            System.out.println(
                    "Reason : All eligibility conditions satisfied");

        } else {

            System.out.println("Loan Status : REJECTED");
            System.out.println("Failed Rules :");

            List<String> failedReasons =
                    service.getFailureReasons(customer);

            for (String reason : failedReasons) {
                System.out.println("- " + reason);
            }
        }
    }
}