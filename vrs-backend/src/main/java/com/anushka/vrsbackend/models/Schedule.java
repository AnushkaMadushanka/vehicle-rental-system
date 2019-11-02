package com.anushka.vrsbackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Class used to keep track of the Schedules
 */
@Document(collection = "Schedules")
public class Schedule {

    /**
     * the unique Id given to the schedule instance
     */
    @Id
    private String id;

    /**
     * pickup date of the schedule
     */
    private Date pickupDate;

    /**
     * drop-off date of the schedule
     */
    private Date dropOffDate;

    /**
     * customer of the schedule
     */
    @DBRef
    private Customer customer;

    /**
     * vehicle of the schedule
     */
    @DBRef
    private Vehicle vehicle;

    /**
     * @param id id of the schedule
     * @param pickupDate pickup date of the schedule
     * @param dropOffDate drop-off date of the schedule
     * @param customer customer of the schedule
     * @param vehicle vehicle of the schedule
     */
    public Schedule(String id, Date pickupDate, Date dropOffDate, Customer customer, Vehicle vehicle) {
        this.id = id;
        this.pickupDate = pickupDate;
        this.dropOffDate = dropOffDate;
        this.customer = customer;
        this.vehicle = vehicle;
    }

    /**
     * Get the id of the schedule
     * @return id of the schedule
     */
    public String getId() {
        return id;
    }

    /**
     * Get the pickup date of the schedule
     * @return pickup date of the schedule
     */
    public Date getPickupDate() {
        return pickupDate;
    }

    /**
     * Set the pickup date of the schedule
     * @param pickupDate pickup date of the schedule
     */
    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    /**
     * Get drop-off date of the schedule
     * @return drop-off date of the schedule
     */
    public Date getDropOffDate() {
        return dropOffDate;
    }

    /**
     * Set the drop-off date of the schedule
     * @param dropOffDate drop-off date of the schedule
     */
    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    /**
     * Get the vehicle of the schedule
     * @return vehicle of the schedule
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Set the vehicle of the schedule
     * @param vehicle vehicle of the schedule
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Get the customer of the schedule
     * @return customer of the schedule
     */
    public Customer getCustomer() {
        return customer;
    }
}