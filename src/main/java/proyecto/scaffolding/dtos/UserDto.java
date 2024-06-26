package proyecto.scaffolding.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long id;

    @JsonProperty("username")
    private String userName;

    @Email
    private String email;
}
