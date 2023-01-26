package com.example.week3_hw4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@Data
public class ApiRequest {

    private String message;
}
