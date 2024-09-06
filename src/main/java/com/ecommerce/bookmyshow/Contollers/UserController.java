package com.ecommerce.bookmyshow.Contollers;

import com.ecommerce.bookmyshow.Models.User;
import com.ecommerce.bookmyshow.dtos.ResponseStatus;
import com.ecommerce.bookmyshow.dtos.SignUpRequestDTO;
import com.ecommerce.bookmyshow.dtos.SignUpResponseDTO;
import com.ecommerce.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

   public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();

        try{
               User user =  userService.signUp(signUpRequestDTO.getName(),signUpRequestDTO.getEmail(),signUpRequestDTO.getPassword());
                signUpResponseDTO.setUser(user);
                signUpResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e)
        {
                signUpResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signUpResponseDTO;

   }

}
