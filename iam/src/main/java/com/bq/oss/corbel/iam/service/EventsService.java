package com.bq.oss.corbel.iam.service;

import java.util.Map;

import com.bq.oss.corbel.iam.model.User;

/**
 * @author Alberto J. Rubio
 */
public interface EventsService {

    void sendUserCreatedEvent(User user);

    void sendUserDeletedEvent(String id, String domain);

    void sendNotificationEvent(String notificationId, String recipient, Map<String, String> properties);

    void sendDomainDeletedEvent(String domainId);
}
