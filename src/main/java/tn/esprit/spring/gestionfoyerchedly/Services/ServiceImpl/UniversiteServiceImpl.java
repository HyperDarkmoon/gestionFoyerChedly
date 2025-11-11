package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Foyer;
import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;
import tn.esprit.spring.gestionfoyerchedly.Repository.FoyerRepository;
import tn.esprit.spring.gestionfoyerchedly.Repository.UniversiteRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IUniversiteService;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() { return universiteRepository.findAll(); }

    @Override
    public Universite addUniversite(Universite u) { return universiteRepository.save(u); }

    @Override
    public Universite updateUniversite(Universite u) { return universiteRepository.save(u); }

    @Override
    public Universite retrieveUniversite(long idUniversite) { return universiteRepository.findById(idUniversite).orElse(null); }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new EntityNotFoundException("Foyer not found: " + idFoyer));

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        if (universite == null) {
            throw new EntityNotFoundException("Universite not found: " + nomUniversite);
        }

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        return universiteRepository.save(universite);
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Universite not found: " + idUniversite));

        Foyer foyer = universite.getFoyer();
        if (foyer != null) {
            universite.setFoyer(null);
            foyer.setUniversite(null);
        }
        return universiteRepository.save(universite);
    }
}
