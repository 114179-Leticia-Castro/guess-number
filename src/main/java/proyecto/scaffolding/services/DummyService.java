package proyecto.scaffolding.services;

import org.springframework.stereotype.Service;
import proyecto.scaffolding.models.Dummy;

import java.util.List;

@Service
public interface DummyService {

    Dummy getDummy(Long id);
    List<Dummy>getDummyList();

    Dummy createDummy(Dummy dummy);
    Dummy UpdateDummy(Dummy dummy);
    void  deleteDummy (Dummy dummy);
}
