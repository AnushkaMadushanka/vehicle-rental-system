package com.anushka.vrsManagerConsole.models;

/**
 * Class used to keep track of users
 */
public class User {
    /**
     * the unique Id given to the user instance
     */
    private String id;

    /**
     * email of the user
     */
    private String email;

    /**
     * encrypted password of the user
     */
    private String password;

    /**
     * role of the user (Customer | Manager)
     */
    private String role;


    /**
     * @param id id of the user
     * @param email email of the user
     * @param password password of the user
     * @param role role of the user
     */
    public User(String id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Get the id of the user
     * @return id of the user
     */
    public String getId() {
        return id;
    }

    /**
     * Get the email of the user
     * @return email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the password of the user
     * @param password password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the password hash of the user
     * @return password hash of the user
     */
    public String getPassword() {
        return password;
    }

    /*
     * Verify the password is correct or not
     * @param password password of the user
     * @return password is correct or not
     */
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Get the role of the user
     * @return role of the user
     */
    public String getRole() {
        return role;
    }

}