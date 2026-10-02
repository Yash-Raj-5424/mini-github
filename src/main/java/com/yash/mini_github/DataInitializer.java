package com.yash.mini_github;

import com.yash.mini_github.model.User;
import com.yash.mini_github.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return args -> {
            if(userRepository.count() == 0){
                userRepository.save(new User(null, "jack", "jack"));
            }
        };
    }
}
