package com.anushka.vrsbackend.repositories;

import com.anushka.vrsbackend.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {
}
