package proyecto.scaffolding.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyecto.scaffolding.models.MatchDifficulty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    private Long id;

    private MatchDifficulty difficulty;

    private Integer remainingTries; //cantidad de intentos que hay q hacer

}
