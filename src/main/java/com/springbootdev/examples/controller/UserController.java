package com.springbootdev.examples.controller;

import com.springbootdev.examples.entity.User;
import com.springbootdev.examples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }


    @GetMapping("/users")
    public List<User> findAll()
    {
        return userRepository.findAll();
    }


    @PutMapping("/users/{user_id}")
    public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject)
    {
        User user = userRepository.findOne(userId);
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }



    @DeleteMapping("/users/{user_id}")
    public List<User> delete(@PathVariable("user_id") Long userId)
    {
        userRepository.delete(userId);
        return userRepository.findAll();
    }



    @GetMapping("/users/{user_id}")
    @ResponseBody
    public User findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.findOne(userId);
    }
}
