package com.josue.technicaltest.client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginRequestDto {

   @NotNull(message = "El username no puede estar vacio")
   @NotBlank
   String username;

   @NotNull(message = "La contraseña no puede estar vacia")
   @NotBlank
   String password;

   public boolean isValid() {
      return username != null && !username.isBlank() && password != null && !password.isBlank();
   }
}
