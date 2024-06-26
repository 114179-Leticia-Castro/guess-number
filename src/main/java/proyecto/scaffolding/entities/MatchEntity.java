package proyecto.scaffolding.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyecto.scaffolding.models.MatchDifficulty;
import proyecto.scaffolding.models.MatchStatus;
import proyecto.scaffolding.models.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne //muchos match van a pertenecer a un usuario, pero un usuario va a existir en un match
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private MatchDifficulty difficulty;

    @Column
    private Integer numberToGuess;

    @Column
    private Integer remainingTries;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;


}
