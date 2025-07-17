package com.josue.technicaltest.controller;

import com.josue.technicaltest.client.dto.LoginRequestDto;
import com.josue.technicaltest.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerV1 {

   private final AuthService authService;


   public AuthControllerV1(AuthService authService) {

      this.authService = authService;
   }


   @PostMapping(value = "/api/v1/login", headers = "X-API-VERSION=1")
   public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
      try {
         return ResponseEntity.ok(authService.login(loginRequestDto));
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }
}
