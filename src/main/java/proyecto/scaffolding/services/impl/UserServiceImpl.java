package proyecto.scaffolding.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.scaffolding.entities.UserEntity;
import proyecto.scaffolding.models.Match;
import proyecto.scaffolding.models.MatchDifficulty;
import proyecto.scaffolding.models.RoundMatch;
import proyecto.scaffolding.models.User;
import proyecto.scaffolding.repositories.UserRepository;
import proyecto.scaffolding.services.MatchService;
import proyecto.scaffolding.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MatchService matchService;

    @Override
    public User createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);
        if (userEntityOptional.isPresent()){//en el caso q encuentre el email
            return null;
        }else {//en caso q no encuentre el email y tenga q hacer la creacion
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setEmail(email);
            //guardamos
            UserEntity userEntitySaved = userRepository.save(userEntity);//piso el repositorio y lo guardo en una entidad nueva
            //esto nos devuelve un usuario, no un UserEntity. mapeamos userEntitySaved a la clase User
            return modelMapper.map(userEntitySaved, User.class);
        }

    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulty difficulty) {
        Optional<UserEntity>userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()){
            throw new EntityNotFoundException();
        }else {
            User user = modelMapper.map(userEntity, User.class);
            return matchService.createMatch(user, difficulty);
        }

    }

    @Override
    public RoundMatch playUserMatch(Long userId, Long matchId, Integer numberToPlay) {
        Match match = matchService.getMatchById(matchId);
        //tengo q hacer todas las validaciones del juego
        if(!match.getUser().getId().equals(userId)){
            // TODO:error
            return null;
        }else { //en el caso q el usuario sea el dueño del juego
            return matchService.playMatch(match, numberToPlay);

        }
    }
}
