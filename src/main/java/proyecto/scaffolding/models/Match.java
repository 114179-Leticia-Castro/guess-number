package proyecto.scaffolding.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    private Long id;
    private User user;
    private MatchDifficulty difficulty;
    private Integer numberToGuess; //numero que hay q adivinar
    private Integer remainingTries; //cantidad de intentos que hay q hacer
    private MatchStatus status;
}
