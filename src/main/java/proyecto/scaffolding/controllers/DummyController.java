package proyecto.scaffolding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.scaffolding.dtos.DummyDto;
import proyecto.scaffolding.models.Dummy;
import proyecto.scaffolding.services.DummyService;

import java.util.List;

@RestController
@RequestMapping("dummy")
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("")
    public ResponseEntity<DummyDto> getDummyList(){ //me retorna todos los dummy
        List<Dummy> dummyList = dummyService.getDummyList();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DummyDto> getDummy(@PathVariable Long id){ //me retorna solo el dummy del id
        Dummy dummy = dummyService.getDummy(id);
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<DummyDto> createDummy(DummyDto dummyDto){
        Dummy dummy = dummyService.createDummy(null);
        return null;
    }

    @PutMapping("/")
    public ResponseEntity<DummyDto> updateDummy(DummyDto dummyDto){
        Dummy dummy = dummyService.createDummy(null);
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<DummyDto> deleteDummy(DummyDto dummyDto){
        dummyService.deleteDummy(null);
        return null;
    }


}
