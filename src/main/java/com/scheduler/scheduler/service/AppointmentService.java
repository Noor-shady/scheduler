package com.scheduler.scheduler.service;

import com.scheduler.scheduler.model.Appointment;
import com.scheduler.scheduler.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private EmailService emailService;

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    @Transactional
    public void createAppointment(Appointment appointment) {
        if (appointment.getEndDateTime() == null) {
            appointment.setEndDateTime(appointment.getStartDateTime().plusHours(1));
        }

        repository.save(appointment);
        logger.info("Saved new appointment for: {}", appointment.getCustomerName());

        String subject = "Appointment Confirmation";
        String body = "Hello " + appointment.getCustomerName() + ",\n\nYour appointment is confirmed for "
                + appointment.getStartDateTime() + ".\n\nThank you!";

        emailService.sendEmail(appointment.getCustomerEmail(), subject, body);
    }
}