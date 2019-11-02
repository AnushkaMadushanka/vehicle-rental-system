package com.anushka.vrsManagerConsole.models;

/**
 * Class used to keep track of cars
 */
public class Car extends Vehicle {

    /**
     * number of seats in the car
     */
    private int numberOfSeats;

    /**
     * boot capacity of the car (dm3)
     */
    private float bootCapacity;

    /**
     * @param id id of the car
     * @param plateNumber plate number of the car
     * @param make brand of the car
     * @param model model of the car
     * @param numberOfSeats number of seats in the car
     * @param bootCapacity boot capacity of the car (dm3)
     */
    public Car(String id, String plateNumber, String make, String model, int numberOfSeats, float bootCapacity) {
        super(id, plateNumber, make, model);
        this.numberOfSeats = numberOfSeats;
        this.bootCapacity = bootCapacity;
    }

    /**
     * Get the number of seats  in the car
     * @return number of seats in the car
     */
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    /**
     * Set the number of seats in the car
     * @param numberOfSeats number of seats in the car
     */
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * Get the boot capacity of the car
     * @return boot capacity of the car
     */
    public float getBootCapacity() {
        return bootCapacity;
    }

    /**
     * Set the boot capacity of the car
     * @param bootCapacity boot capacity of the car
     */
    public void setBootCapacity(float bootCapacity) {
        this.bootCapacity = bootCapacity;
    }

}