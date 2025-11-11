package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Etudiant;
import tn.esprit.spring.gestionfoyerchedly.Repository.EtudiantRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IEtudiantService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() { return etudiantRepository.findAll(); }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) { return etudiantRepository.saveAll(etudiants); }

    @Override
    public Etudiant updateEtudiant(Etudiant e) { return etudiantRepository.save(e); }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) { return etudiantRepository.findById(idEtudiant).orElse(null); }

    @Override
    public void removeEtudiant(long idEtudiant) { etudiantRepository.deleteById(idEtudiant); }
}
