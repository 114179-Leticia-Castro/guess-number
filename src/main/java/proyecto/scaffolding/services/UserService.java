package proyecto.scaffolding.services;

import org.springframework.stereotype.Service;
import proyecto.scaffolding.models.Match;
import proyecto.scaffolding.models.MatchDifficulty;
import proyecto.scaffolding.models.RoundMatch;
import proyecto.scaffolding.models.User;

@Service
public interface UserService {

    User createUser(String userName, String email);

    Match createUserMatch(Long userId, MatchDifficulty difficulty);

    RoundMatch playUserMatch(Long userId, Long matchId, Integer numberToPlay);
}
