package proyecto.scaffolding.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoundMatchDto {
    private MatchDto matchDto;
    private String respuesta;

}
