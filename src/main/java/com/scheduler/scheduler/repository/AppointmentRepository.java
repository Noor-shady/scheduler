package com.scheduler.scheduler.repository;

import com.scheduler.scheduler.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByStartDateTimeBetween(LocalDateTime start, LocalDateTime end);

    // Prevent Double Booking: Custom JPQL query to check if a new appointment overlaps with an existing one
    @Query("SELECT COUNT(a) > 0 FROM Appointment a WHERE (a.startDateTime < :end AND a.endDateTime > :start)")
    boolean existsByOverlappingTime(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    // User Dashboard Feature: Find all appointments for a specific customer
    List<Appointment> findByCustomerEmail(String email);
}