package com.cts.elearn.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.elearn.dao.NotificationRepository;
import com.cts.elearn.entity.Notification;
import com.cts.elearn.entity.Notification.NotificationType;

@Configuration
public class NotificationDataLoader {

    @Bean
    CommandLineRunner loadNotifications(
            NotificationRepository repo) {

        return args -> {

            if(repo.count() == 0) {

                Notification n1 =
                        new Notification();

                n1.setRecipientId(2); // Anil
                n1.setNotificationMessage(
                        "Welcome to ELEARN Platform");
                n1.setNotificationType(
                        NotificationType.EMAIL);

                repo.save(n1);

                Notification n2 =
                        new Notification();

                n2.setRecipientId(2);
                n2.setNotificationMessage(
                        "Course Purchased Successfully - Java Backend Development");
                n2.setNotificationType(
                        NotificationType.IN_APP);

                repo.save(n2);

                Notification n3 =
                        new Notification();

                n3.setRecipientId(3); // Instructor
                n3.setNotificationMessage(
                        "New Learner Enrolled In Your Course");
                n3.setNotificationType(
                        NotificationType.EMAIL);

                repo.save(n3);

                System.out.println(
                        "Sample Notifications Loaded");
            }
        };
    }
}