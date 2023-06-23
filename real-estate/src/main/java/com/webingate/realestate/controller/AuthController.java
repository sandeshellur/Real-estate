package com.webingate.realestate.controller;

import com.webingate.realestate.model.User;
import com.webingate.realestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${database.name}")
    private String Schema;

     */

    @Autowired
    UserRepository userRepository;

    //Sign Up
    @PostMapping("/signup")
    public User singUp(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/signup")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    //Log In
    @PostMapping("/login")
    public User logIn(@RequestBody User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /*
    @GetMapping("GetUsersFromDB")
    public List<User> GetPropertiesFromDB() {

        List<User> user = new ArrayList<User>();


        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName(Schema).withProcedureName("GetUsersList");

        //Map<String, Object> inParamMap = new HashMap<String, Object>();

        //inParamMap.put("i_Id", id);


        try {
            Map<String, Object> resultData = simpleJdbcCall.execute();

            for (java.util.Map.Entry<String, Object> e : resultData.entrySet()) {
                String key = e.getKey();

                if (e.getValue() instanceof List) {
                    List obj = (List) e.getValue();
                    for (int i = 0; i < obj.size(); i++) {

                        User c = new User();
                        Map map = (Map) obj.get(i);
                        c.setId((Integer) map.get("id"));

                        user.add(c);
                        //
                    }
                }

            }
        } catch (Exception e) {

        }

        return user;
    }

    @PostMapping("insertbook")
    public List<User> insertbook(User b) {

        List<User> users = new ArrayList<User>();


        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName(Schema).withProcedureName("insertuser");


        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("bookname", b.getUsername());
        inParamMap.put("author", b.getPassword());


        try {
            Map<String, Object> resultData = simpleJdbcCall.execute(inParamMap);

            for (java.util.Map.Entry<String, Object> e : resultData.entrySet()) {
                String key = e.getKey();

                if (e.getValue() instanceof List) {
                    List obj = (List) e.getValue();
                    for (int i = 0; i < obj.size(); i++) {

                        User c = new User();
                        Map map = (Map) obj.get(i);
                        c.setId((Integer) map.get("id"));
                        c.setUsername((String) map.get("username"));
                        c.setPassword((String) map.get("password"));
                        c.setFirstName((String) map.get("firstname"));
                        c.setLastName((String) map.get("lastname"));
                        users.add(c);
                        //
                    }
                }

            }
        } catch (Exception e) {

        }

        return users;
    }

     */


}
