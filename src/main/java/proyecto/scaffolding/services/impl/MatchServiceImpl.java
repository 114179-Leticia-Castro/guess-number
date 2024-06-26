package proyecto.scaffolding.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.scaffolding.entities.MatchEntity;
import proyecto.scaffolding.entities.UserEntity;
import proyecto.scaffolding.models.*;
import proyecto.scaffolding.repositories.MatchRepository;
import proyecto.scaffolding.services.MatchService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();//nos permite generar numeros random(aleatorios)

    @Override
    public Match createMatch(User user, MatchDifficulty matchDifficulty) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(user, UserEntity.class));//seteo el usuario y lo mapeo
        matchEntity.setDifficulty(matchDifficulty);
        switch (matchDifficulty){
            case HARD -> matchEntity.setRemainingTries(5);
            case MEDIUM -> matchEntity.setRemainingTries(8);
            case EASY -> matchEntity.setRemainingTries(10);
        }
        //le seteo para q me pida un numero random del 1 al 101
        matchEntity.setNumberToGuess(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        //guardo la jugada en matchentitySaved
        MatchEntity matchEntitySaved = matchRepository.save(matchEntity);
        //me retorna el mapeo en la clase Match
        return  modelMapper.map(matchEntitySaved, Match.class);

    }

    @Override
    public Match getMatchById(Long matchId) {
        Optional<MatchEntity> matchEntityOptional =matchRepository.findById(matchId);
        if (matchEntityOptional.isEmpty()){
            throw new EntityNotFoundException();
        }else {
            return modelMapper.map(matchEntityOptional.get(), Match.class);
        }
    }

    @Override
    public RoundMatch playMatch(Match match, Integer number) {
        RoundMatch roundMatch = new RoundMatch();
        roundMatch.setMatch(match);
        //verificamos el estado del match
        if (match.getStatus().equals(MatchStatus.FINISH)){
            //TODO:error
            return null;
        }
        if (match.getNumberToGuess().equals(number)){
            //TODO: calcular score
            //TODO: dar respuesta
            match.setStatus(MatchStatus.FINISH);
            roundMatch.setRespuesta("GANO");

        }
        else {
            //reduzco los intentos
            match.setRemainingTries(match.getRemainingTries()-1);
            if (match.getRemainingTries().equals(0)){
                match.setStatus(MatchStatus.FINISH);
                roundMatch.setRespuesta("PERDIO");
            }else {
                if (number > match.getNumberToGuess()){
                    roundMatch.setRespuesta("MENOR");

                }else {
                    roundMatch.setRespuesta("MAYOR");
                }
            }
        }
        //mapeamos el usuario
        UserEntity userEntity = modelMapper.map(match.getUser(), UserEntity.class);
        MatchEntity matchEntity = modelMapper.map(match, MatchEntity.class);
        matchEntity.setUserEntity(userEntity);
        matchEntity.setUpdatedAt(LocalDateTime.now());
        //guardamos actualizacion

        matchRepository.save(matchEntity);
        return roundMatch;
    }
}
