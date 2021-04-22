package com.sinapps.repositories;

import com.sinapps.models.CarPark;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 repository interface for car park
 - findByName
 */

public interface CarParkRepository extends CrudRepository<CarPark, Long> {

    List<CarPark> findByName(String name);
}
