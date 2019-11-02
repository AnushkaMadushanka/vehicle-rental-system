package com.anushka.vrsManagerConsole.concretes;

import com.anushka.vrsManagerConsole.models.Car;
import com.anushka.vrsManagerConsole.models.Motorbike;
import com.anushka.vrsManagerConsole.models.Schedule;
import com.anushka.vrsManagerConsole.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ApplicationManager {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("Enter 1 to view vehicles");
        System.out.println("Enter 2 to add vehicle");
        System.out.println("Enter 3 to update vehicle");
        System.out.println("Enter 4 to delete vehicle");
        System.out.println("Enter 5 to view  reservations");
        System.out.println("Enter 6 to cancel reservations");

        System.out.println("Enter 99 to Exit the program");
        System.out.println("-------------------------------------");
        int answer = Objects.requireNonNull(getInputInt(true));
        System.out.println("-------------------------------------");

        switch (answer) {
            case 1:
                viewVehicles();
                break;
            case 2:
                addVehicle();
                break;
            case 3:
                updateVehicle();
                break;
            case 4:
                deleteVehicle();
                break;
            case 99:
                return;
            default:
                System.out.println("Enter a valid number");
                break;
        }
        System.out.println("-------------------------------------");
        start();
    }

    private static void addVehicle() {
        System.out.println("Enter 1 if you want to add a car");
        System.out.println("Enter 2 if you want to add a motorbike");
        int answer = Objects.requireNonNull(getInputInt(true));

        System.out.println("Enter vehicle plate number");
        String plateNumber = getRequiredInput();
        System.out.println("Enter vehicle make");
        String make = getRequiredInput();
        System.out.println("Enter vehicle model");
        String model = getRequiredInput();

        Vehicle vehicle = null;

        switch (answer) {
            case 1:
                System.out.println("Enter number of seats in the car");
                int numberOfSeats = Objects.requireNonNull(getInputInt(true)) ;
                System.out.println("Enter the boot capacity of the car");
                float bootCapacity = Objects.requireNonNull(getInputFloat(true));
                vehicle = new Car("", plateNumber, make, model, numberOfSeats, bootCapacity);
                break;
            case 2:
                System.out.println("Enter the seat height of the motorbike");
                float seatHeight = Objects.requireNonNull(getInputFloat(true));
                System.out.println("Does the motorbike has self start (y/n)");
                boolean selfStart = Objects.requireNonNull(getInputChoice(new ArrayList<>(List.of("y", "n")), true)).equals("y");
                vehicle = new Motorbike("", plateNumber, make, model, seatHeight, selfStart);
                break;
        }

        try {
            WestministerRentalVehicleManager.addVehicle(vehicle);
        } catch (Exception e) {
            System.out.println("Error Occurred Try Again");
            addVehicle();
        }
    }

    private static void viewVehicles() {
        try {
            ArrayList<Vehicle> vehicles = WestministerRentalVehicleManager.viewVehicles();
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    System.out.println("Id: " + car.getId() + ", Plate number: " + car.getPlateNumber() + ", Make: " + car.getMake() + ", Model: " + car.getModel() + ", Number of seats: " + car.getNumberOfSeats() + ", Boot capacity: " + car.getBootCapacity());
                } else {
                    Motorbike motorbike = (Motorbike) vehicle;
                    System.out.println("Id: " + motorbike.getId() + ", Plate number: " + motorbike.getPlateNumber() + ", Make: " + motorbike.getMake() + ", Model: " + motorbike.getModel() + ", Seat height: " + motorbike.getSeatHeight() + ", Self start: " + (motorbike.getSelfStart() ? "yes" : "no"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteVehicle() {
        System.out.println("Enter vehicle id that you want to delete");
        String vehicleId = getRequiredInput();
        try {
            WestministerRentalVehicleManager.deleteVehicle(vehicleId);
        } catch (Exception e) {
            System.out.println("Error Occurred Try Again");
            deleteVehicle();
        }
    }

    private static void updateVehicle() {

        System.out.println("Enter vehicle id that you want to update");
        String vehicleId = getRequiredInput();
        Vehicle vehicle;
        try {
            vehicle = WestministerRentalVehicleManager.getVehicleById(vehicleId);
        } catch (Exception e) {
            System.out.println("Error Occurred Try Again");
            updateVehicle();
            return;
        }
        try {
            System.out.println("Keep the value empty if you don't want to update the value");

            System.out.println("Enter vehicle plate number ("+vehicle.getPlateNumber()+")");
            String plateNumber = scanner.nextLine();
            System.out.println("Enter vehicle make ("+vehicle.getMake()+")");
            String make = scanner.nextLine();
            System.out.println("Enter vehicle model ("+vehicle.getModel()+")");
            String model = scanner.nextLine();

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;

                System.out.println("Enter number of seats in the car ("+car.getNumberOfSeats()+")");
                Integer numberOfSeats = getInputInt(false);
                System.out.println("Enter the boot capacity of the car ("+car.getBootCapacity()+")");
                Float bootCapacity = getInputFloat(false);

                if (!plateNumber.isEmpty()) car.setPlateNumber(plateNumber);
                if (!make.isEmpty()) car.setMake(make);
                if (!model.isEmpty()) car.setModel(model);
                if (numberOfSeats != null) car.setNumberOfSeats(numberOfSeats);
                if (bootCapacity != null) car.setBootCapacity(bootCapacity);

                WestministerRentalVehicleManager.updateVehicle(car);

            } else {
                Motorbike motorbike = (Motorbike) vehicle;

                System.out.println("Enter the seat height of the motorbike ("+motorbike.getSeatHeight()+")");
                Float seatHeight = getInputFloat(false);
                System.out.println("Does the motorbike has self start (y/n) ("+(motorbike.getSelfStart() ? "yes" : "no")+")");
                String selfStart = getInputChoice(new ArrayList<>(List.of("y", "n")), false);

                if (!plateNumber.isEmpty()) motorbike.setPlateNumber(plateNumber);
                if (!make.isEmpty()) motorbike.setMake(make);
                if (!model.isEmpty()) motorbike.setModel(model);
                if (seatHeight != null) motorbike.setSeatHeight(seatHeight);
                if (selfStart != null) motorbike.setSelfStart(selfStart.equals("y"));

                WestministerRentalVehicleManager.updateVehicle(motorbike);

            }
        } catch (Exception e) {
            System.out.println("Error Occurred Try Again");
            updateVehicle();
        }
    }

    private static void viewReservations() {
        try {
            ArrayList<Schedule> schedules = WestministerRentalVehicleManager.viewReservations();
            for (Schedule schedule : schedules) {
                System.out.println("Id: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Integer getInputInt(boolean isRequired) {
        try {
            String line = scanner.nextLine();
            if (line.isEmpty() && !isRequired)
                return null;
            return Integer.parseInt(line);
        } catch (Exception ex) {
            System.out.println("Enter a valid number");
            return getInputInt(isRequired);
        }
    }

    private static Float getInputFloat(boolean isRequired) {
        try {
            String line = scanner.nextLine();
            if (line.isEmpty() && !isRequired)
                return null;
            return Float.parseFloat(line);
        } catch (Exception ex) {
            System.out.println("Enter a valid value");
            return getInputFloat(isRequired);
        }
    }

    private static String getRequiredInput() {
        String line = scanner.nextLine();
        if (line != null && !line.isEmpty())
            return line;
        return getRequiredInput();
    }

    private static String getInputChoice(ArrayList<String> choices, boolean isRequired) {
        try {
            String line = scanner.nextLine();
            if (line.isEmpty() && !isRequired)
                return null;
            return choices.stream().filter(choice -> line.toLowerCase().equals(choice.toLowerCase())).findAny().orElseThrow(Exception::new);
        } catch (Exception ex) {
            System.out.println("Enter a valid choice");
            return getInputChoice(choices, isRequired);
        }
    }

}
