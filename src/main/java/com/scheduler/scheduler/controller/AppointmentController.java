package com.scheduler.scheduler.controller;

import com.scheduler.scheduler.model.Appointment;
import com.scheduler.scheduler.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/booking")
    public String showBookingForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "booking";
    }

    // Handle the Form Submission (Save the appointment)
    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.createAppointment(appointment);
        return "redirect:/";
    }

    // API Endpoint: Send Data to the Frontend Calendar (JSON)
