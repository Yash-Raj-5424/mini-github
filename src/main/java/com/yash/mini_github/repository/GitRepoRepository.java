package com.yash.mini_github.repository;

import com.yash.mini_github.model.GitRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GitRepoRepository extends JpaRepository<GitRepo, Long> {

    List<GitRepo> findByOwnerId(Long ownerId);
}
