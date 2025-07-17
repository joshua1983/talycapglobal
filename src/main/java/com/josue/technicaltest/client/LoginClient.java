package com.josue.technicaltest.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.josue.technicaltest.client.dto.LoginRequestDto;
import com.josue.technicaltest.client.dto.LoginResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "loginClient", url = "${clients.login.base}")
public interface LoginClient {
   @PostMapping("${clients.login.url}")
   LoginResponseDto loginUser(LoginRequestDto login);

   @GetMapping("${clients.login.auth}")
   JsonNode userData(@RequestHeader("Authorization") String token);
}
