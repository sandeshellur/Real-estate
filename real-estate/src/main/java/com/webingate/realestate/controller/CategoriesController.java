package com.webingate.realestate.controller;

import com.webingate.realestate.model.Category;
import com.webingate.realestate.repository.CategoriesRepository;
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
public class CategoriesController {


    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${database.name}")
    private String Schema;

     */


    @Autowired
    CategoriesRepository categoriesRepository;

    @GetMapping("/categories")
    public List<Category> getCities() {
        return (List<Category>) categoriesRepository.findAll();
    }

    /*
    @GetMapping("GetCategoriesFromDB")
    public List<Category> GetCategoriesFromDB(){

        List<Category> category = new ArrayList<Category>();


        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName(Schema).withProcedureName("GetCategoriesList");

        //Map<String, Object> inParamMap = new HashMap<String, Object>();

        //inParamMap.put("i_Id", id);


        try {
            Map<String, Object> resultData = simpleJdbcCall.execute();

            for (java.util.Map.Entry<String, Object> e : resultData.entrySet()) {
                String key = e.getKey();

                if (e.getValue() instanceof List) {
                    List obj = (List) e.getValue();
                    for (int i = 0; i < obj.size(); i++) {

                        Category c = new Category();
                        Map map = (Map) obj.get(i);
                        c.setId((Integer) map.get("id"));

                        category.add(c);
                        //
                    }
                }

            }
        } catch (Exception e) {

        }

        return category;
    }

     */

}
