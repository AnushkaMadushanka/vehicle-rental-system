package com.anushka.vrsbackend.controllers;

import com.anushka.vrsbackend.abstracts.RentalVehicleManager;
import com.anushka.vrsbackend.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private RentalVehicleManager rentalVehicleManager;

    @PostMapping
    public void insert(@RequestBody Customer customer){
        rentalVehicleManager.register(customer);
    }

}
