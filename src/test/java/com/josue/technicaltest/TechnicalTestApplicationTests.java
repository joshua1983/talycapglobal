package com.josue.technicaltest;

import com.fasterxml.jackson.databind.JsonNode;
import com.josue.technicaltest.client.LoginClient;
import com.josue.technicaltest.client.dto.LoginRequestDto;
import com.josue.technicaltest.client.dto.LoginResponseDto;
import com.josue.technicaltest.exceptions.AuthenticationTokenException;
import com.josue.technicaltest.exceptions.BadCredentialsException;
import com.josue.technicaltest.model.Constants;
import com.josue.technicaltest.service.AuthService;
import com.josue.technicaltest.service.SaveLog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TechnicalTestApplicationTests {

   @Mock
   private LoginClient loginClient;

   @Mock
   private SaveLog saveLog;

   @InjectMocks
   private AuthService authService;


   @Test
   void testLogin() throws AuthenticationTokenException, BadCredentialsException {

      String tokenDummy = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
      String refreshTokenDummy = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
      String username = "emilys";
      String password = "emilyspass";
      String responseData = "User data retrieved successfully";
      JsonNode dataResponse = Mockito.mock(JsonNode.class);
      LoginRequestDto loginRequestDto = new LoginRequestDto(username, password);
      LoginResponseDto loginResponseDto = new LoginResponseDto(tokenDummy,
                                                               refreshTokenDummy,
                                                               1,
                                                               username,
                                                               "emily.johnson@x.dummyjson.com",
                                                               "Emily",
                                                               "Johnson",
                                                               "female",
                                                               "https://dummyjson.com/icon/emilys/128");
      Mockito.when(loginClient.loginUser(loginRequestDto)).thenReturn(loginResponseDto);
      Mockito.when(dataResponse.has("id")).thenReturn(true);
      Mockito.when(dataResponse.toPrettyString()).thenReturn(responseData);
      Mockito.when(loginClient.userData(any())).thenReturn(dataResponse);


      String resultLogin = authService.login(loginRequestDto);
      assertEquals(resultLogin, responseData);

   }
   @Test
   void testLoginBadCredentials() {

      String tokenDummy = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
      String refreshTokenDummy = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
      String username = "emilys";
      String password = "emilyspass";
      LoginRequestDto loginRequestDto = new LoginRequestDto(username, password);
      LoginResponseDto loginResponseDto = new LoginResponseDto(tokenDummy,
                                                               refreshTokenDummy,
                                                               1,
                                                               username,
                                                               "emily.johnson@x.dummyjson.com",
                                                               "Emily",
                                                               "Johnson",
                                                               "female",
                                                               "https://dummyjson.com/icon/emilys/128");
      Mockito.when(loginClient.loginUser(loginRequestDto)).thenReturn(loginResponseDto);
      Mockito.when(loginClient.userData(any())).thenReturn(null);


      assertThrowsExactly(AuthenticationTokenException.class,
                          () -> authService.login(loginRequestDto),
                          Constants.ERROR_FAIL_LOGIN);


   }


   @Test
   void testLoginEmptyUser() {

      String username = "";
      String password = "emilyspass";
      LoginRequestDto loginRequestDto = new LoginRequestDto(username, password);

      assertThrowsExactly(BadCredentialsException.class,
                          () -> authService.login(loginRequestDto),
                          Constants.ERROR_INVALID_DATA);

   }


   @Test
   void testLoginEmptyPassword() {

      String username = "emily";
      String password = "";
      LoginRequestDto loginRequestDto = new LoginRequestDto(username, password);

      assertThrowsExactly(BadCredentialsException.class,
                          () -> authService.login(loginRequestDto),
                          Constants.ERROR_INVALID_DATA);

   }

}
