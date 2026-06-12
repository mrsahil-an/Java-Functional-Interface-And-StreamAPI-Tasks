package com.belenits.model;

public class Notification {

    private String notificationId;
    private String userName;
    private String email;
    private String mobile;
    private String message;
    private String notificationType;
    private String priority;

    public Notification(String notificationId, String userName, String email, String mobile, String message, String notificationType, String priority) {
        this.notificationId = notificationId;
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.message = message;
        this.notificationType = notificationType;
        this.priority = priority;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
