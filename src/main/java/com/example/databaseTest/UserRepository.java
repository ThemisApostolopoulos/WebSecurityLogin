package com.example.databaseTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT u FROM User u WHERE u.username=?1")
    public User findByUsername(String username);

    @Query(value = "UPDATE User  u SET u.failedAttempts=?2 WHERE u.username=?1")
    public void updateFailedAttempts(String username, int failedAttempts);

}
