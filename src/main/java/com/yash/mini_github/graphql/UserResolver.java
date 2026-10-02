package com.yash.mini_github.graphql;

import com.yash.mini_github.model.User;
import com.yash.mini_github.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserResolver {

    private final UserRepository userRepository;

    public UserResolver(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @QueryMapping
    public User user(@Argument String username){
        return userRepository.findByUsername(username)
                .orElse(null);
    }

    @QueryMapping
    public List<User> users(){
        return userRepository.findAll();
    }
}
