package com.anushka.vrsbackend.models;

/**
 * Class used to keep track of customers
 */
public class Customer extends User {

    /**
     * phone number of the customer;
     */
    private String phone;

    /**
     * address of the customer;
     */
    private String address;


    /**
     * @param id id of the customer
     * @param email email of the customer
     * @param password password of the customer
     * @param phone phone number of the customer
     * @param address address of the customer
     */
    public Customer(String id, String email, String password, String phone, String address) {
        super(id, email, password, "customer");
        this.phone = phone;
        this.address = address;
    }

    /**
     * Get the phone number of the customer
     * @return phone number of the customer
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number of the customer
     * @param phone phone number of the customer
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get the address of the customer
     * @return address of the customer
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the customer
     * @param address address of the customer
     */
    public void setAddress(String address) {
        this.address = address;
    }

}