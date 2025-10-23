package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;
import tn.esprit.spring.gestionfoyerchedly.Repository.UniversiteRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IUniversiteService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversities() { return universiteRepository.findAll(); }

    @Override
    public Universite addUniversite(Universite u) { return universiteRepository.save(u); }

    @Override
    public Universite updateUniversite(Universite u) { return universiteRepository.save(u); }

    @Override
    public Universite retrieveUniversite(long idUniversite) { return universiteRepository.findById(idUniversite).orElse(null); }
}
