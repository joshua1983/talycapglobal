package com.josue.technicaltest.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginClientConfig {
   @Bean
   public RequestInterceptor authInterceptor(){
      return requestTemplate -> requestTemplate.header("access_token", "");
   }
}
