package proyecto.scaffolding.services;

import org.springframework.stereotype.Service;
import proyecto.scaffolding.models.Match;
import proyecto.scaffolding.models.MatchDifficulty;
import proyecto.scaffolding.models.RoundMatch;
import proyecto.scaffolding.models.User;

@Service
public interface MatchService {

    Match createMatch(User user, MatchDifficulty difficulty);

    Match getMatchById(Long matchId);

    RoundMatch playMatch(Match match, Integer number);
}
