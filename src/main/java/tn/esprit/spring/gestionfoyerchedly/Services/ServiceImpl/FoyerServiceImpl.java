package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Foyer;
import tn.esprit.spring.gestionfoyerchedly.Repository.FoyerRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IFoyerService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}
