package com.example.recherche.Controller;

import com.example.recherche.model.LoginRequest;
import com.example.recherche.model.User;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController

public class AppController {
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public User userLogin(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        Optional<User> user = getValidUsers()
                .stream()
                .filter(u -> u.getUserName().equalsIgnoreCase(loginRequest.getName()))
                .findFirst();

        if (user.isPresent()) {
            return user.get();
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> listUsers() {
        return getValidUsers();
    }

    private List<User> getValidUsers() {
        List<User> validUsers = new ArrayList<>();

        if (!validUsers.isEmpty()) {
            return validUsers;
        } else {
            validUsers = new ArrayList<>();
            validUsers.add(new User(1, "user1"));
            validUsers.add(new User(2, "user2"));
            validUsers.add(new User(3, "user3"));
            return validUsers;
        }
    }



}
