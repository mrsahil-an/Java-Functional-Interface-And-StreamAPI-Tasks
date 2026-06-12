package com.belenits.com.belenits.runners;

import com.belenits.model.Notification;
import com.belenits.service.NotificationRouter;

import java.util.Arrays;
import java.util.List;

public class NotificationApplication {

    public static void main(String[] args) {

        NotificationRouter router = new NotificationRouter();

        List<Notification> notifications = Arrays.asList(

                // HIGH Priority
                new Notification(
                        "N101",
                        "Ravi",
                        "ravi@gmail.com",
                        "9876543210",
                        "Your class starts at 7:30 AM",
                        "SMS",
                        "HIGH"
                ),

                // NORMAL Priority - SMS
                new Notification(
                        "N102",
                        "Priya",
                        "priya@gmail.com",
                        "9988776655",
                        "Your OTP is 458921",
                        "SMS",
                        "NORMAL"
                ),

                // NORMAL Priority - EMAIL
                new Notification(
                        "N103",
                        "Arjun",
                        "arjun@gmail.com",
                        "9123456789",
                        "Interview scheduled tomorrow",
                        "EMAIL",
                        "NORMAL"
                ),

                // HIGH Priority - Mobile Missing
                new Notification(
                        "N104",
                        "Sneha",
                        "sneha@gmail.com",
                        null,
                        "Urgent account verification required",
                        "EMAIL",
                        "HIGH"
                ),

                // NORMAL Priority - Email Missing
                new Notification(
                        "N105",
                        "Kiran",
                        null,
                        "9000011111",
                        "Monthly report available",
                        "EMAIL",
                        "NORMAL"
                )
        );

        notifications.forEach(notification -> {
            System.out.println("\n=================================");
            System.out.println("Notification ID : "
                    + notification.getNotificationId());

            router.route(notification);
        });
    }
}