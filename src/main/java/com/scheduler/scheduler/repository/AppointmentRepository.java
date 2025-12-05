package com.scheduler.scheduler.repository;

import com.scheduler.scheduler.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // .save(), .findAll(), .delete(), .findById()
    // I will add custom queries later like this:
    // List<Appointment> findByCustomerEmail(String email);
}

