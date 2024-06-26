package proyecto.scaffolding.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "users")
@Data
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;
}
