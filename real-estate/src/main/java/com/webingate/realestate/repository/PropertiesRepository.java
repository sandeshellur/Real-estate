package com.webingate.realestate.repository;

import com.webingate.realestate.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends CrudRepository<Property, Integer> {
    Object findByLocationId(int locationId);
}
