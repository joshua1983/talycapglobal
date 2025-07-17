package com.josue.technicaltest.service;

import com.josue.technicaltest.model.LoginRecord;
import com.josue.technicaltest.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@Component
public class SaveLog {
   private final UserRepository userRepository;
    public SaveLog(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
   public void storeLoginLog(String username, String accessToken, String refreshToken) {

      LoginRecord recordLogin = new LoginRecord(
         UUID.randomUUID().toString(),
         username,
         new Date(System.currentTimeMillis()),
         accessToken,
         refreshToken
      );
      userRepository.save(recordLogin);
   }
}
