package com.example.controller;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @PostMapping("/regi")

    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepository.findByUserName(user.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("this user is already register..");
        }
        userRepository.save(user);
        return ResponseEntity.ok("user register sucee...");
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user)
        {
        Optional<User> optionalUser=userRepository.findByUserName(user.getUserName());
        if (optionalUser.isPresent())
        {
            User existingUser=optionalUser.get();
            if (existingUser.getPassword().equals(user.getPassword())){
            }
                sendEmail(existingUser.getUserName());
                return ResponseEntity.ok("login successfully....");
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid password");
            }
        }
          public  void sendEmail(String username) {
                    String toEmail = "sohilkhan11110@gmail.com";
                    String subject = " login notification";
                    String text = "hello"+username+"your login successfully";

                    SimpleMailMessage email = new SimpleMailMessage();
                    email.setTo(toEmail);
                    email.setSubject(subject);
                    email.setText(text);
                    javaMailSender.send(email);

    }
}
