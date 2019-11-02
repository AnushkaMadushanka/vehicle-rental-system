package com.anushka.vrsbackend.controllers;

import com.anushka.vrsbackend.abstracts.RentalVehicleManager;
import com.anushka.vrsbackend.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private RentalVehicleManager rentalVehicleManager;

    @GetMapping
    public List<Schedule> getAll(){
        return rentalVehicleManager.viewReservations();
    }

    @GetMapping("/{id}")
    public Schedule getById(@PathVariable("id") String id){
        return rentalVehicleManager.getReservationById(id);
    }

    @PostMapping
    public void insert(@RequestBody Schedule schedule){
        rentalVehicleManager.makeReservation(schedule);
    }

    @PutMapping
    public void update(@RequestBody Schedule schedule){
        rentalVehicleManager.updateReservation(schedule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        rentalVehicleManager.cancelReservations(id);
    }

}
