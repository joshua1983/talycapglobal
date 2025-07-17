package com.josue.technicaltest.client.dto;

public record LoginResponseDto (
   String accessToken,
   String refreshToken,
   int id,
   String username,
   String email,
   String firstName,
   String lastName,
   String gender,
   String image
) {}
