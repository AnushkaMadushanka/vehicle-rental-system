package com.anushka.vrsManagerConsole.models;

/**
 * Class used to keep track of motorbikes
 */
public class Motorbike extends Vehicle {

    /**
     * height of the seat of the motorbike
     */
    private float seatHeight;

    /**
     * is self start available in the motorbike
     */
    private boolean selfStart;

    /**
     * @param id id of the motorbike
     * @param plateNumber plate number of the motorbike
     * @param make brand of the motorbike
     * @param model model of the motorbike
     * @param seatHeight height of the seat of the motorbike
     * @param selfStart is self start available in the motorbike
     */
    public Motorbike(String id, String plateNumber, String make, String model, float seatHeight, boolean selfStart) {
        super(id, plateNumber, make, model);
        this.seatHeight  = seatHeight;
        this.selfStart = selfStart;
    }

    /**
     * Get the height of the seat of the motorbike
     * @return height of the seat of the motorbike
     */
    public float getSeatHeight() {
        return seatHeight;
    }

    /**
     * Set the height of the seat of the motorbike
     * @param seatHeight height of the seat of the motorbike
     */
    public void setSeatHeight(float seatHeight) {
        this.seatHeight = seatHeight;
    }

    /**
     * check whether the self start is available or not
     * @return is self start available in the motorbike
     */
    public boolean getSelfStart() {
        return selfStart;
    }

    /**
     * set the self start is available or not
     * @param selfStart is self start available in the motorbike
     */
    public void setSelfStart(boolean selfStart) {
        this.selfStart = selfStart;
    }

}