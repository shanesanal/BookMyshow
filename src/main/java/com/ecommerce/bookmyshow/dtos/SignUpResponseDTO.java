package com.ecommerce.bookmyshow.dtos;

import com.ecommerce.bookmyshow.Models.User;
import lombok.Data;

@Data
public class SignUpResponseDTO {
    private User user;
    private ResponseStatus responseStatus;
}
