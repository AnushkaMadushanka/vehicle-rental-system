package com.anushka.vrsbackend.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* Class used to keep track of vehicles
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "motorbike")
})
@Document(collection = "Vehicles")
public abstract class Vehicle {

    /**
     * the unique Id given to the vehicle instance
     */
    @Id
    private String id;

    /**
     * plate number of the vehicle
     */
    private String plateNumber;

    /**
     * brand of the vehicle
     */
    private String make;

    /**
     * model of the vehicle
     */
    private String model;


    /**
     * @param id id of the vehicle
     * @param plateNumber plate number of the vehicle
     * @param make brand of the vehicle
     * @param model model of the vehicle
     */
    public Vehicle(String id, String plateNumber, String make, String model) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
    }

    /**
     * Get the id of the vehicle
     * @return id of the vehicle
     */
    public String getId() {
        return id;
    }

    /**
     * Get the plate number of the vehicle
     * @return plate number of the vehicle
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Set the plate number of the vehicle
     * @param plateNumber plate number of the vehicle
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * Get the brand of the vehicle
     * @return brand of the vehicle
     */
    public String getMake() {
        return make;
    }

    /**
     * Set the brand of the vehicle
     * @param make brand of the vehicle
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Get the model of the vehicle
     * @return model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the model of the vehicle
     * @param model model of the vehicle
     */
    public void setModel(String model) {
        this.model = model;
    }

}