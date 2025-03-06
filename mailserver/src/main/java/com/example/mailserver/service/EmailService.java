package com.example.mailserver.service;

import com.example.mailserver.model.Email;
import com.example.mailserver.repository.EmailRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Optional<Email> getEmailById(Long id) {
        return emailRepository.findById(id);
    }

    public List<Email> getEmailsSentBy(String fromEmail) {
        return emailRepository.findByFromEmail(fromEmail);
    }

    public List<Email> getEmailsReceivedBy(String toEmail) {
        return emailRepository.findByToEmail(toEmail);
    }

    public Email sendEmail(Email email) {
        email.setTimestamp(LocalDateTime.now());
        return emailRepository.save(email);
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}
