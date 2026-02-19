package com.scheduler.scheduler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String customerName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String customerEmail;

    @NotNull(message = "Start date and time are required")
    @FutureOrPresent(message = "Appointment must be in the future")
    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public Appointment() {}

    public Appointment(String customerName, String customerEmail, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public LocalDateTime getStartDateTime() { return startDateTime; }
    public void setStartDateTime(LocalDateTime startDateTime) { this.startDateTime = startDateTime; }
    public LocalDateTime getEndDateTime() { return endDateTime; }
    public void setEndDateTime(LocalDateTime endDateTime) { this.endDateTime = endDateTime; }
}