package com.josue.technicaltest.repository;

import com.josue.technicaltest.model.LoginRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<LoginRecord, String> {
}
