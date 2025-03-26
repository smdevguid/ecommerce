package edu.sm_devguid.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // Crea los getter and setters
@AllArgsConstructor // Define un constructor con todos los atributos de la clase
@NoArgsConstructor //Constructor vacio
public class User {
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellPhone;
    private String password;
    private UserType userType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
