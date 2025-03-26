package edu.sm_devguid.ecommerce.backend.infraestructure;

import edu.sm_devguid.ecommerce.backend.domain.model.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String address;
    private String cellPhone;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
