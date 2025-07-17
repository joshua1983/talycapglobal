package com.josue.technicaltest.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.josue.technicaltest.client.LoginClient;
import com.josue.technicaltest.client.dto.LoginRequestDto;
import com.josue.technicaltest.client.dto.LoginResponseDto;
import com.josue.technicaltest.exceptions.AuthenticationTokenException;
import com.josue.technicaltest.exceptions.BadCredentialsException;
import com.josue.technicaltest.model.Constants;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


   private final LoginClient loginClient;
   private final SaveLog saveLog;


   public AuthService(LoginClient loginClient, SaveLog saveLog) {

      this.loginClient = loginClient;
      this.saveLog = saveLog;
   }


   public String login(LoginRequestDto loginRequest) throws BadCredentialsException, AuthenticationTokenException {

      if (loginRequest != null && !loginRequest.isValid()) {
         throw new BadCredentialsException(Constants.ERROR_INVALID_DATA);
      }

      LoginResponseDto loginResponseDto = loginClient.loginUser(loginRequest);
      if (loginResponseDto == null || loginResponseDto.accessToken() == null) {
         throw new BadCredentialsException(Constants.ERROR_FAIL_LOGIN);
      }
      String token = "Bearer " + loginResponseDto.accessToken();
      String refreshToken = loginResponseDto.refreshToken();
      JsonNode jsonNode = loginClient.userData(token);
      if (jsonNode == null || !jsonNode.has("id")) {
         throw new AuthenticationTokenException(Constants.ERROR_NO_DATA);
      }
      saveLog.storeLoginLog(loginResponseDto.username(), token, refreshToken);
      return jsonNode.toPrettyString();
   }


}
