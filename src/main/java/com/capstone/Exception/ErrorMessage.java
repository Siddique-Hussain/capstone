package com.capstone.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder

public class ErrorMessage
{
    String message;
    HttpStatus status;
}
