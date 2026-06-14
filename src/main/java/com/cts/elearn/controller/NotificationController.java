package com.cts.elearn.controller;

import com.cts.elearn.entity.Notification;
import com.cts.elearn.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications") // Base path for all endpoints
public class NotificationController {

    @GetMapping("/test")
    public String test() {
        return "Notification Service Working";
    }

    @Autowired
    private NotificationService notificationService;

    // 🔹 Create a new notification
    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    // 🔹 Get all notifications
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // 🔹 Get notification by ID
    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable int id) {
        return notificationService.getNotificationById(id);
    }

    // 🔹 Update an existing notification
    @PutMapping("/{id}")
    public void updateNotification(@PathVariable int id, @RequestBody Notification notification) {
        notification.setNotificationId(id); // Ensure correct ID is set
        notificationService.updateNotification(notification);
    }

    // 🔹 Delete a notification by ID
    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable int id) {
        notificationService.deleteNotification(id);
    }
}
