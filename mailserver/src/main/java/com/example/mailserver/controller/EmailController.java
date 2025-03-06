package com.example.mailserver.controller;

import com.example.mailserver.model.Email;
import com.example.mailserver.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emails")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        return emailService.getEmailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sent/{fromEmail}")
    public List<Email> getEmailsSentBy(@PathVariable String fromEmail) {
        return emailService.getEmailsSentBy(fromEmail);
    }

    @GetMapping("/received/{toEmail}")
    public List<Email> getEmailsReceivedBy(@PathVariable String toEmail) {
        return emailService.getEmailsReceivedBy(toEmail);
    }

    @PostMapping
    public Email sendEmail(@RequestBody Email email) {
        return emailService.sendEmail(email);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }
}
