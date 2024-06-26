package proyecto.scaffolding.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.scaffolding.models.Dummy;
import proyecto.scaffolding.repositories.DummyRepository;
import proyecto.scaffolding.services.DummyService;

import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    public DummyRepository dummyRepository;

    @Override
    public Dummy getDummy(Long id) {
        return null;
    }

    @Override
    public List<Dummy> getDummyList() {
        return null;
    }

    @Override
    public Dummy createDummy(Dummy dummy) {
        return null;
    }

    @Override
    public Dummy UpdateDummy(Dummy dummy) {
        return null;
    }

    @Override
    public void deleteDummy(Dummy dummy) {

    }
}
