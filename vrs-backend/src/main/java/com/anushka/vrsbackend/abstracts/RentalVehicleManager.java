package com.anushka.vrsbackend.abstracts;

import com.anushka.vrsbackend.models.Customer;
import com.anushka.vrsbackend.models.Schedule;
import com.anushka.vrsbackend.models.Vehicle;

import java.util.*;

/**
 * Interface for the rental vehicle system
 */
public interface RentalVehicleManager {


    /**
     * Login the user through credentials
     * @param email email of the user
     * @param password password of the user
     * @return token
     */
    public String login(String email, String password);

    /**
     * register a new customer
     * @param customer details of the customer
     */
    public void register(Customer customer);

    /**
     * Add a new vehicle
     * @param vehicle details of the vehicle
     */
    public void addVehicle(Vehicle vehicle);

    /**
     * Update an existing vehicle
     * @param vehicle details of the vehicle
     */
    public void updateVehicle(Vehicle vehicle);

    /**
     * Delete a vehicle from the system
     * @param vehicleId id of the vehicle
     */
    public void deleteVehicle(String vehicleId);

    /**
     * Get the vehicle using the vehicle id
     * @param vehicleId id of the vehicle
     */
    public Vehicle getVehicleById(String vehicleId);

    /**
     * Get all vehicles in the system
     * @return list of all vehicles
     */
    public List<Vehicle> viewVehicles();

    /**
     * Make a reservation for a vehicle
     * @param schedule details of the reservation
     */
    public void makeReservation(Schedule schedule);

    /**
     * Update an existing vehicle
     * @param schedule details of the schedule
     */
    public void updateReservation(Schedule schedule);

    /**
     * Cancel an existing reservation
     * @param reservationId id of the reservation
     */
    public void cancelReservations(String reservationId);

    /**
     * Get all reservations in the system
     * @return list of all reservations
     */
    public List<Schedule> viewReservations();

    /**
     * Get the reservation using the reservation id
     * @param reservationId id of the reservation
     */
    public Schedule getReservationById(String reservationId);

}