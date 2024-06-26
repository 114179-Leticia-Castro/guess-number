package proyecto.scaffolding.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyecto.scaffolding.models.MatchDifficulty;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserMatchDto {
    private MatchDifficulty difficulty;
}
