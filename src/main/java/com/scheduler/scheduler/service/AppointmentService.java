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