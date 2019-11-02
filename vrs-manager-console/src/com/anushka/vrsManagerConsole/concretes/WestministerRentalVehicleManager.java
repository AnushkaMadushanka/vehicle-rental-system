package com.anushka.vrsManagerConsole.concretes;

import com.anushka.vrsManagerConsole.adapters.VehicleAdapter;
import com.anushka.vrsManagerConsole.models.Car;
import com.anushka.vrsManagerConsole.models.Schedule;
import com.anushka.vrsManagerConsole.models.Vehicle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class WestministerRentalVehicleManager {

    private static String baseUrl = "http://localhost:8080";

    public static void login(String email, String password) {

    }

    public static void addVehicle(Vehicle vehicle) throws Exception {
        String endPointUrl = baseUrl + "/api/vehicle";
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Vehicle.class, new VehicleAdapter());
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(vehicle, Vehicle.class);
        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
    }

    public static void updateVehicle(Vehicle vehicle) throws Exception {
        String endPointUrl = baseUrl + "/api/vehicle";
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Vehicle.class, new VehicleAdapter());
        Gson gson = gsonBuilder.create();

        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(vehicle, Vehicle.class)))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
    }

    public static void deleteVehicle(String vehicleId) throws Exception {
        String endPointUrl = baseUrl + "/api/vehicle/" + vehicleId;
        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .DELETE()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
    }

    public static ArrayList<Vehicle> viewVehicles() throws Exception {
        String endPointUrl = baseUrl + "/api/vehicle";
        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Vehicle.class, new VehicleAdapter());
        Gson gson = gsonBuilder.create();
        Type type = new TypeToken<ArrayList<Vehicle>>() {
        }.getType();

        return gson.fromJson(response.body(), type);
    }

    public static Vehicle getVehicleById(String vehicleId) throws Exception {
        String endPointUrl = baseUrl + "/api/vehicle/"+vehicleId;
        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Vehicle.class, new VehicleAdapter());
        Gson gson = gsonBuilder.create();
        return gson.fromJson(response.body(), Vehicle.class);
    }

    public static void cancelReservations(String reservationId) throws Exception {
        String endPointUrl = baseUrl + "/api/schedule/" + reservationId;
        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .DELETE()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
    }

    public static ArrayList<Schedule> viewReservations() throws Exception {
        String endPointUrl = baseUrl + "/api/schedule";
        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type type = new TypeToken<ArrayList<Schedule>>() {
        }.getType();

        return gson.fromJson(response.body(), type);
    }

    public static Schedule getScheduleById(String vehicleId) throws Exception {
        String endPointUrl = baseUrl + "/api/schedule/"+vehicleId;
        HttpRequest request = HttpRequest.newBuilder(new URI(endPointUrl))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != HttpURLConnection.HTTP_OK)
            throw new Exception("Request Failed");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(response.body(), Schedule.class);
    }
}
