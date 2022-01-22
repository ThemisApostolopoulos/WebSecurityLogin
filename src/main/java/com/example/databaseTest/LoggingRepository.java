package com.example.databaseTest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
public interface LoggingRepository extends JpaRepository<Logging,LoggindId> {
}
