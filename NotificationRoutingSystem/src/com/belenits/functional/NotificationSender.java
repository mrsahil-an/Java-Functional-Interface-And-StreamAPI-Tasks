package com.belenits.functional;

import com.belenits.model.Notification;

@FunctionalInterface
public interface NotificationSender {

    void send(Notification notification);

}
