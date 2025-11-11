package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import tn.esprit.spring.gestionfoyerchedly.Repository.BlocRepository;
import tn.esprit.spring.gestionfoyerchedly.Repository.ChambreRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IBlocService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BlocServiceImpl implements IBlocService {
    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;

    public BlocServiceImpl(BlocRepository blocRepository, ChambreRepository chambreRepository) {
        this.blocRepository = blocRepository;
        this.chambreRepository = chambreRepository;
    }

    @Override
    public List<Bloc> retrieveBlocs() { return blocRepository.findAll(); }

    @Override
    public Bloc addBloc(Bloc bloc) { return blocRepository.save(bloc); }

    @Override
    public Bloc updateBloc(Bloc bloc) { return blocRepository.save(bloc); }

    @Override
    public Bloc retrieveBloc(long idBloc) { return blocRepository.findById(idBloc).orElse(null); }

    @Override
    public void removeBloc(long idBloc) { blocRepository.deleteById(idBloc); }

    @Override
    public Bloc affecterChambresABloc(List<Double> numChambre, int IdBloc) {
        Bloc bloc = blocRepository.findById((long) IdBloc).orElse(null);
        if (bloc == null) return null;

        // Convert Double numbers to Long since entity uses long numeroChambre
        List<Long> numeros = numChambre.stream()
                .map(Double::longValue)
                .collect(Collectors.toList());

        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numeros);
        for (Chambre ch : chambres) {
            ch.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);
        return blocRepository.findById((long) IdBloc).orElse(bloc);
    }

    @Override
    public List<Bloc> findByFoyerUniversiteNomUniversite(String nom) {
        return blocRepository.findByFoyerUniversiteNomUniversite(nom);
    }

}
