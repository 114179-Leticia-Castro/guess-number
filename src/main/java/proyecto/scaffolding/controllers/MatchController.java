package proyecto.scaffolding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.scaffolding.services.MatchService;

@RestController
@RequestMapping("/guess-number/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;
}
