package com.bugapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugapp.model.Bug;

public interface BugRepo extends JpaRepository<Bug, Long> {

}
