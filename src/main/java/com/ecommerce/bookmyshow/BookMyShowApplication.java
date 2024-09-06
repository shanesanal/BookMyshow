package com.ecommerce.bookmyshow;

import com.ecommerce.bookmyshow.Contollers.UserController;
import com.ecommerce.bookmyshow.dtos.SignUpRequestDTO;
import com.ecommerce.bookmyshow.dtos.SignUpResponseDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

    private UserController userController;
    public BookMyShowApplication(UserController userController) {
        this.userController = userController;
    }
    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
        signUpRequestDTO.setName("Doe");
        signUpRequestDTO.setEmail("doey@gmail.com");
        signUpRequestDTO.setPassword("pass");
        SignUpResponseDTO signUpResponseDTO =userController.signUp(signUpRequestDTO);
    }

}
