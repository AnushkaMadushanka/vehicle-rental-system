package com.anushka.vrsManagerConsole.adapters;

import com.anushka.vrsManagerConsole.models.Car;
import com.anushka.vrsManagerConsole.models.Motorbike;
import com.anushka.vrsManagerConsole.models.Vehicle;
import com.google.gson.*;

import java.lang.reflect.Type;

public class VehicleAdapter implements JsonSerializer<Vehicle>, JsonDeserializer<Vehicle> {
    @Override
    public Vehicle deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String vehicleType = jsonObject.get("type").getAsString();
        return jsonDeserializationContext.deserialize(jsonElement, vehicleType.equals("car") ? Car.class: Motorbike.class);
    }

    @Override
    public JsonElement serialize(Vehicle vehicle, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement result = jsonSerializationContext.serialize(vehicle, vehicle.getClass());
        JsonObject jsonObject = result.getAsJsonObject();
        jsonObject.addProperty("type", vehicle.getClass().getSimpleName().toLowerCase());
        return jsonObject;
    }
}
