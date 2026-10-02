package com.yash.mini_github.graphql;

import com.yash.mini_github.model.GitRepo;
import com.yash.mini_github.model.User;
import com.yash.mini_github.repository.GitRepoRepository;
import com.yash.mini_github.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserResolver {

    private final UserRepository userRepository;
    private final GitRepoRepository gitRepoRepository;

    public UserResolver(UserRepository userRepository, GitRepoRepository gitRepoRepository){
        this.userRepository = userRepository;
        this.gitRepoRepository = gitRepoRepository;
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

    @MutationMapping
    public GitRepo createRepo(
            @Argument String name,
            @Argument String description,
            @Argument String ownerUsername
    ){

        User owner = userRepository.findByUsername(ownerUsername)
                .orElseThrow();

        GitRepo repo = new GitRepo();
        repo.setName(name);
        repo.setDescription(description);
        repo.setOwner(owner);

        return gitRepoRepository.save(repo);
    }
}
