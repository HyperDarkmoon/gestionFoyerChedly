package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import tn.esprit.spring.gestionfoyerchedly.Repository.ChambreRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IChambreService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() { return chambreRepository.findAll(); }

    @Override
    public Chambre addChambre(Chambre c) { return chambreRepository.save(c); }

    @Override
    public Chambre updateChambre(Chambre c) { return chambreRepository.save(c); }

    @Override
    public Chambre retrieveChambre(long idChambre) { return chambreRepository.findById(idChambre).orElse(null); }
}
