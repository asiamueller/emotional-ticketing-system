package com.example.ticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class RequestController {

    // POST request to submit a ticket
    @PostMapping("/submit")
    public ResponseEntity<String> submitRequest(@RequestBody String content) {
        // Check if content is valid
        if (content == null || content.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Content cannot be empty.");
        }

        // Save the ticket request
        boolean isSaved = saveRequest(content);
        
        if (!isSaved) {
            return ResponseEntity.status(500).body("Error: Ticket not submitted due to server issue.");
        }

        return ResponseEntity.ok("Ticket submitted successfully.");
    }

    // Simulate saving the ticket request
    private boolean saveRequest(String content) {
        try {
            // Simulate saving to a database or file (for testing purposes)
            System.out.println("Saving ticket request: " + content);
            // Assume saving is successful
            return true;
        } catch (Exception e) {
            // If there’s an error while saving the request, return false
            System.err.println("Error while saving ticket request: " + e.getMessage());
            return false;
        }
    }
}
