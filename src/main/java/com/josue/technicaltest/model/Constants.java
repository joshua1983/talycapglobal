package com.josue.technicaltest.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Constants {

   public static String ERROR_INVALID_DATA = "Datos inválidos, por favor verifique su usuario y contraseña";
   public static String ERROR_FAIL_LOGIN= "Login fallido, por favor verifique su usuario y contraseña";
   public static String ERROR_NO_DATA = "Failed to retrieve user data";
}
