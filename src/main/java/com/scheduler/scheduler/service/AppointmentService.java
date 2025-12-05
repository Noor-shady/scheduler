package com.scheduler.scheduler.service;

import com.scheduler.scheduler.model.Appointment;
import com.scheduler.scheduler.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    // Save a new appointment (This handles the Booking Form)
    public void createAppointment(Appointment appointment) {
        // Business Logic:
        // If the frontend didn't send an end time, we default to 1 hour.
        if (appointment.getEndDateTime() == null) {
            appointment.setEndDateTime(appointment.getStartDateTime().plusHours(1));
        }

        // Save to Database
        repository.save(appointment);
    }
}