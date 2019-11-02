package com.anushka.vrsbackend.controllers;

import com.anushka.vrsbackend.abstracts.RentalVehicleManager;
import com.anushka.vrsbackend.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private RentalVehicleManager rentalVehicleManager;

    @GetMapping
    public List<Vehicle> getAll(){
        return rentalVehicleManager.viewVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable("id") String id){
        return rentalVehicleManager.getVehicleById(id);
    }

    @PostMapping
    public void insert(@RequestBody Vehicle vehicle){
        rentalVehicleManager.addVehicle(vehicle);
    }

    @PutMapping
    public void update(@RequestBody Vehicle vehicle){
        rentalVehicleManager.updateVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        rentalVehicleManager.deleteVehicle(id);
    }

}
