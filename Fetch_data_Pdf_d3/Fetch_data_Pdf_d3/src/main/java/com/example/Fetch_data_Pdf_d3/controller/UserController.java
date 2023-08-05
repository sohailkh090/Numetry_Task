package com.example.Fetch_data_Pdf_d3.controller;
import com.example.Fetch_data_Pdf_d3.model.User;
import com.example.Fetch_data_Pdf_d3.services.UserServices;
import com.example.Fetch_data_Pdf_d3.userPDFExporter.UserPDFExporter;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/save")
    public User saveData(@RequestBody User user){
        return  userServices.saveData(user);
    }
    @GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userServices.listAll();

        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(response);

    }
}
