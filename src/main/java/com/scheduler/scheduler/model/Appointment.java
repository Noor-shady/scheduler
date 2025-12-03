package com.scheduler.scheduler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerEmail;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Appointment() {
    }

    public Appointment(String customerName, String customerEmail, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }




