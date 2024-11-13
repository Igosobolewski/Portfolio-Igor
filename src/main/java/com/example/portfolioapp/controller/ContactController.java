package com.example.portfolioapp.controller;

import com.example.portfolioapp.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping
    public String submitContactForm(ContactForm contactForm, Model model) {
        try{SimpleMailMessage message = new SimpleMailMessage();;
            message.setTo("igosobolewski@gmail.com");
            message.setSubject("Wiadomość z konta od: " + contactForm.getName());
            message.setText("Imię: " + contactForm.getName() + "\n" + contactForm.getEmail() + "\n" + contactForm.getMessage());
            mailSender.send(message);
            model.addAttribute("SuccessMessage", "Wiadomość wsyłana!");
    }catch(Exception e){
        model.addAttribute("ErrorMessage", "Wystąpił błąd!");
    }
return "contact";
    }
}
