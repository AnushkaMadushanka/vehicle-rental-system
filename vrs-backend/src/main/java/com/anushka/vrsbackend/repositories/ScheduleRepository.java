package com.anushka.vrsbackend.repositories;

import com.anushka.vrsbackend.models.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule,String> {
}
