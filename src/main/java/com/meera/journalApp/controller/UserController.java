package com.meera.journalApp.controller;

import com.meera.journalApp.api.response.WeatherResponse;
import com.meera.journalApp.entity.User;
import com.meera.journalApp.service.UserService;
import com.meera.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WeatherService weatherService;

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDB = userService.findByUsername(username);
        userInDB.setUsername(user.getUsername());
        userInDB.setPassword(user.getPassword());
        userService.saveUserEntry(userInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        if(user!=null) {
            userService.deleteById(user.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{city}")
    public ResponseEntity<?> getUserWeather(@PathVariable String city) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String message = "Hi " + authentication.getName();
        WeatherResponse response = weatherService.getWeather(city);
        if(response!=null) {
            message += ", weather feels like " + response.getCurrent().getFeelslikeC();
        } 
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
