package com.webingate.realestate.controller;

import com.webingate.realestate.model.Property;
import com.webingate.realestate.repository.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class PropertiesController {

    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${database.name}")
    private String Schema;

     */
    @Autowired
    PropertiesRepository propertiesRepository;

    // Fetch all properties
    @GetMapping("/propertiesall")
    public List<Property> getPropertiesAll() {
        return (List<Property>) propertiesRepository.findAll();
    }

    // Fetch properties by location
    @GetMapping("/propertybylocation/{locationId}")
    public List<Property> getPropertyByLocation(@PathVariable int locationId) {
        return (List<Property>) propertiesRepository.findByLocationId(locationId);
    }

    /*
    @GetMapping("GetPropertiesFromDB")
    public List<Property> GetPropertiesFromDB(){

        List<Property> properties = new ArrayList<Property>();


        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName(Schema).withProcedureName("GetPropertiesList");

        //Map<String, Object> inParamMap = new HashMap<String, Object>();

        //inParamMap.put("i_Id", id);


        try {
            Map<String, Object> resultData = simpleJdbcCall.execute();

            for (java.util.Map.Entry<String, Object> e : resultData.entrySet()) {
                String key = e.getKey();

                if (e.getValue() instanceof List) {
                    List obj = (List) e.getValue();
                    for (int i = 0; i < obj.size(); i++) {

                        Property c = new Property();
                        Map map = (Map) obj.get(i);
                        c.setId((Integer) map.get("id"));

                        properties.add(c);
                        //
                    }
                }

            }
        } catch (Exception e) {

        }

        return properties;
    }

     */
}
