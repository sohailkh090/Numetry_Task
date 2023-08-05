package com.example.Fetch_data_Pdf_d3.services;

import com.example.Fetch_data_Pdf_d3.model.User;
import com.example.Fetch_data_Pdf_d3.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServices {
     
    @Autowired
    private UserRepository userRepository;

    public User saveData(User user){
        return userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll(Sort.by("email").ascending());
    }
     
}
