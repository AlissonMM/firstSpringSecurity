package alisson.firstSpringSecurity.controller;


import alisson.firstSpringSecurity.model.User;
import alisson.firstSpringSecurity.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping()
    public String getUsers() throws JsonProcessingException {
        List<User> users = userRepository.findAll();
        //ObjectMapper is used to convert Java objects to JSON
        return objectMapper.writeValueAsString(users);
    }
}
