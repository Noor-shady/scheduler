package com.scheduler.scheduler.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.scheduler.scheduler.model.Appointment;
import com.scheduler.scheduler.service.AppointmentService;

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

    // Handle Form Submission with Validation
    @PostMapping("/book")
    public String bookAppointment(@Valid @ModelAttribute Appointment appointment, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Return to the form if there are validation errors
            return "booking";
        }

        appointmentService.createAppointment(appointment);
        return "redirect:/?success";
    }

    @GetMapping("/api/appointments")
    @ResponseBody
    public List<Map<String, Object>> getAppointments() {
        List<Appointment> all = appointmentService.getAllAppointments();
        List<Map<String, Object>> events = new ArrayList<>();

        for (Appointment a : all) {
            Map<String, Object> event = new HashMap<>();
            event.put("id", a.getId());
            event.put("title", a.getCustomerName());
            event.put("start", a.getStartDateTime().toString());
            event.put("end", a.getEndDateTime().toString());
            events.add(event);
        }
        return events;
    }
}