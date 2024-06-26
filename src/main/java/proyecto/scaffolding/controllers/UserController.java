package proyecto.scaffolding.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.scaffolding.dtos.*;
import proyecto.scaffolding.models.Match;
import proyecto.scaffolding.models.MatchDifficulty;
import proyecto.scaffolding.models.RoundMatch;
import proyecto.scaffolding.models.User;
import proyecto.scaffolding.services.UserService;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
       User user = userService.createUser(userDto.getUserName(),userDto.getEmail());
        UserDto userDtoCreated = modelMapper.map(user, UserDto.class);
       return ResponseEntity.ok(userDtoCreated);
    }

    @PostMapping("/{userId}/matches")
    public ResponseEntity<MatchDto> createUserMatch(@PathVariable Long userId,@RequestBody CreateUserMatchDto createUserMatchDto){
        Match match = userService.createUserMatch(userId,createUserMatchDto.getDifficulty());
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);

        return ResponseEntity.ok(matchDto);
    }

    @PostMapping("/{userId}/matches/{matchId}")
    public ResponseEntity<RoundMatchDto> playUserMatch(@PathVariable Long userId, @PathVariable Long matchId, @RequestBody PlayUserMatchDto playUserMatchDto){
        RoundMatch roundMatch = userService.playUserMatch(userId,matchId,playUserMatchDto.getNumber());
        MatchDto matchDto = modelMapper.map(roundMatch.getMatch(), MatchDto.class);
        RoundMatchDto roundMatchDto = modelMapper.map(roundMatch, RoundMatchDto.class);
        roundMatchDto.setMatchDto(matchDto);

       return ResponseEntity.ok(roundMatchDto);
    }
}
