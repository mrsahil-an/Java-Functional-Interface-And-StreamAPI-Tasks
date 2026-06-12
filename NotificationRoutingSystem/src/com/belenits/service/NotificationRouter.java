package com.belenits.service;

import com.belenits.functional.NotificationSender;
import com.belenits.model.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class NotificationRouter {

    private final Map<String, NotificationSender> senderRegistry =
            new HashMap<>();

    public NotificationRouter() {

        NotificationSender emailSender = notification ->
                System.out.println("Email Sent to "
                        + notification.getEmail());

        NotificationSender smsSender = notification ->
                System.out.println("SMS Sent to "
                        + notification.getMobile());

        NotificationSender whatsappSender = notification ->
                System.out.println("WhatsApp Sent to "
                        + notification.getMobile());

        NotificationSender pushSender = notification ->
                System.out.println("Push Notification Sent to "
                        + notification.getUserName());

        senderRegistry.put("EMAIL", emailSender);
        senderRegistry.put("SMS", smsSender);
        senderRegistry.put("WHATSAPP", whatsappSender);
        senderRegistry.put("PUSH", pushSender);
    }

    public void route(Notification notification) {

        if ("HIGH".equalsIgnoreCase(notification.getPriority())) {

            System.out.println("Sending HIGH priority notification...");

            Stream.of("EMAIL", "WHATSAPP")
                    .forEach(channel ->
                            sendNotification(channel, notification));

        } else {

            System.out.println("Sending NORMAL priority notification...");

            sendNotification(
                    notification.getNotificationType(),
                    notification
            );
        }

        System.out.println("Message: "
                + notification.getMessage());
    }

    private void sendNotification(
            String channel,
            Notification notification) {

        if ("EMAIL".equalsIgnoreCase(channel)
                && isBlank(notification.getEmail())) {

            System.out.println(
                    "Email skipped - email not available");
            return;
        }

        if (("SMS".equalsIgnoreCase(channel)
                || "WHATSAPP".equalsIgnoreCase(channel))
                && isBlank(notification.getMobile())) {

            System.out.println(
                    channel + " skipped - mobile not available");
            return;
        }

        Optional.ofNullable(senderRegistry.get(channel))
                .ifPresent(sender ->
                        sender.send(notification));
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}