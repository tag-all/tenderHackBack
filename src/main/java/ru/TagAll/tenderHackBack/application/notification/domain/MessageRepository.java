package ru.TagAll.tenderHackBack.application.notification.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
