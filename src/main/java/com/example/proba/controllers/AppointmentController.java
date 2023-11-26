package com.example.proba.controllers;
import com.example.proba.models.Appointment;
import com.example.proba.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/view")
    public String showRegistrationForm(@RequestParam(name="name",required = false) String name, Model model) {
        model.addAttribute("appointment", appointmentService.listAppointment(name));
        return "appoinment";
    }

    @PostMapping("/add")
    public String addToCart(Appointment appointment) {
        System.out.println(appointment);
        appointmentService.addToAppoinment(appointment);
        return "gg";
    }



}
