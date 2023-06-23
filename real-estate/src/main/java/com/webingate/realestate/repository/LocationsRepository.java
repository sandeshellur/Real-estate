package com.webingate.realestate.repository;

import com.webingate.realestate.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends CrudRepository<Location, Integer> {
}
