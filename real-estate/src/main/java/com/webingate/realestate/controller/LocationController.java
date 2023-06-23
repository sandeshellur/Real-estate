package com.webingate.realestate.controller;

import com.webingate.realestate.model.Location;
import com.webingate.realestate.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LocationController {

    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${database.name}")
    private String Schema;

     */

    @Autowired
    LocationsRepository locationsRepository;

    @GetMapping("/locations")
    public List<Location> getCities() {
        return (List<Location>) locationsRepository.findAll();
    }

    /*
    @GetMapping("GetLocationsFromDB")
    public List<Location> GetLocationsFromDB(){

        List<Location> locations = new ArrayList<Location>();


        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName(Schema).withProcedureName("GetLocationsList");

        //Map<String, Object> inParamMap = new HashMap<String, Object>();

        //inParamMap.put("i_Id", id);


        try {
            Map<String, Object> resultData = simpleJdbcCall.execute();

            for (java.util.Map.Entry<String, Object> e : resultData.entrySet()) {
                String key = e.getKey();

                if (e.getValue() instanceof List) {
                    List obj = (List) e.getValue();
                    for (int i = 0; i < obj.size(); i++) {

                        Location c = new Location();
                        Map map = (Map) obj.get(i);
                        c.setId((Integer) map.get("id"));

                        locations.add(c);
                        //
                    }
                }

            }
        } catch (Exception e) {

        }

        return locations;
    }

     */
}
