package com.example.databaseTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
public interface LoggingRepository extends JpaRepository<Logging,LoggindId> {

//    @Query(value = "INSERT INTO logging (username,timestamp) VALUES (?1,?2)", nativeQuery = true)
//    public void saveLogging(String username, Date timestamp);
}
