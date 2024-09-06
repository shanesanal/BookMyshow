package com.ecommerce.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private String name;
    private String email;
    private String password;
}
