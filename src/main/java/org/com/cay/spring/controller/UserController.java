package org.com.cay.spring.controller;

import org.com.cay.spring.entity.User;
import org.com.cay.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author:       Caychen
 * Class:        org.com.cay.spring.controller.UserController
 * Date:         2018/11/28
 * Desc:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @InitBinder
    public void stringToDate(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public User save(User user){
        userService.save(user);
        return user;
    }

    @GetMapping("/searchByName")
    public List<User> searchByName(String name){
        return userService.searchByName(name);
    }

    @GetMapping("/searchByAge")
    public List<User> searchByAge(
            @RequestParam(defaultValue = "0", required = false) Integer minAge,
            @RequestParam(defaultValue = "100", required = false) Integer maxAge){
        return userService.searchByAge(minAge, maxAge);
    }

    @GetMapping("/searchByRegex")
    public List<User> searchByRegex(String nameRegex){
        return userService.searchByRegex(nameRegex);
    }
}
