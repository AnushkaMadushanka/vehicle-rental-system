package com.anushka.vrsbackend.concretes;

import com.anushka.vrsbackend.abstracts.RentalVehicleManager;
import com.anushka.vrsbackend.models.*;
import com.anushka.vrsbackend.repositories.ScheduleRepository;
import com.anushka.vrsbackend.repositories.UserRepository;
import com.anushka.vrsbackend.repositories.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WestminsterRentalVehicleManager implements RentalVehicleManager {

    private VehicleRepository vehicleRepository;
    private ScheduleRepository scheduleRepository;
    private UserRepository userRepository;


    public WestminsterRentalVehicleManager(VehicleRepository vehicleRepository, ScheduleRepository scheduleRepository, UserRepository userRepository){
        this.vehicleRepository = vehicleRepository;
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    public String login(String email, String password) {
        return null;
    }

    public void register(Customer customer) {
        if (customer.getEmail().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email cannot be empty");
        if (customer.getPassword().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Password cannot be empty");
        if (customer.getPhone().isEmpty() && customer.getAddress().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"one of phone or address has to be filled");
        userRepository.insert(customer);
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getMake().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Make cannot be empty");
        if (vehicle.getModel().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Model cannot be empty");
        if (vehicle.getPlateNumber().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Plate number cannot be empty");
        if(vehicle instanceof Car){
            Car car = (Car)vehicle;
            if (car.getBootCapacity() <= 0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a valid boot capacity");
            if (car.getNumberOfSeats() <= 0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a valid Number of seats");
        } else {
            Motorbike motorbike = (Motorbike) vehicle;
            if (motorbike.getSeatHeight() <= 0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a valid seat height");
        }

        vehicleRepository.insert(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        if (vehicle.getMake().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Make cannot be empty");
        if (vehicle.getModel().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Model cannot be empty");
        if (vehicle.getPlateNumber().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Plate number cannot be empty");
        if(vehicle instanceof Car){
            Car car = (Car)vehicle;
            if (car.getBootCapacity() <= 0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a valid boot capacity");
            if (car.getNumberOfSeats() <= 0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a valid Number of seats");
        } else {
            Motorbike motorbike = (Motorbike) vehicle;
            if (motorbike.getSeatHeight() <= 0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter a valid seat height");
        }
        vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(String vehicleId) {
        if(vehicleId.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vehicle id is empty");
        vehicleRepository.deleteById(vehicleId);
    }

    public List<Vehicle> viewVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(String vehicleId){
        if (vehicleId == null || vehicleId.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vehicle id is empty");
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No vehicle found");
        return vehicle;
    }

    public void makeReservation(Schedule schedule) {
        if (schedule.getCustomer() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "customer is empty");
        if(schedule.getDropOffDate() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "drop off date is empty");
        if(schedule.getPickupDate() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "pickup date is empty");
        if (schedule.getVehicle() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vehicle is empty");

        scheduleRepository.insert(schedule);
    }

    public void updateReservation(Schedule schedule) {
        if (schedule.getCustomer() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "customer is empty");
        if(schedule.getDropOffDate() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "drop off date is empty");
        if(schedule.getPickupDate() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "pickup date is empty");
        if (schedule.getVehicle() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vehicle is empty");
        scheduleRepository.save(schedule);
    }

    public void cancelReservations(String reservationId) {
        if (reservationId.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "vehicle id is empty");
        scheduleRepository.deleteById(reservationId);
    }

    public List<Schedule> viewReservations() {
        return scheduleRepository.findAll();
    }

    public Schedule getReservationById(String scheduleId){
        if (scheduleId == null || scheduleId.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "schedule id is empty");
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        if (schedule == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No vehicle found");
        return schedule;
    }
}
