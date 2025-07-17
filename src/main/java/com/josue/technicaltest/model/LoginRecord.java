package com.josue.technicaltest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "login_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRecord{
   @Id
   String id;

   @Column(nullable = false, name = "username")
   String username;

   @Column(nullable = false, name = "login_time")
   Date loginTime;

   @Column(length = 2048, nullable = false, name = "access_token")
   String accessToken;

   @Column(length = 2048, nullable = false, name = "refresh_token")
   String refreshToken;
}
