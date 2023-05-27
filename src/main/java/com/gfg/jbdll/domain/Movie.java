package com.gfg.jbdll.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;


@Getter
public class Movie {
   private int id;
   @NotBlank(message = "title is mandatory")
   private String title;
   private String genre;
   @Min(value=0,message = "Rating cannot be negative")
   @Max(value = 5,message = "Rating cannot be more that 5")
   private Double rating;
   @Email
   private String directorEmail;

}
