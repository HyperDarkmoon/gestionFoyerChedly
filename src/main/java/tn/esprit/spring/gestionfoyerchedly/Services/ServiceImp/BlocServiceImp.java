package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import tn.esprit.spring.gestionfoyerchedly.Repository.BlocRepository;
import tn.esprit.spring.gestionfoyerchedly.Repository.ChambreRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterfaces.BlocServiceInterfaces;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlocServiceImp implements BlocServiceInterfaces {

    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() { return blocRepository.findAll(); }

    @Override
    public Bloc updateBloc(Bloc bloc) { return blocRepository.save(bloc); }

    @Override
    public Bloc addBloc(Bloc bloc) { return blocRepository.save(bloc); }

    @Override
    public Bloc retrieveBloc(long idBloc) { return blocRepository.findById(idBloc).orElse(null); }

    @Override
    public void removeBloc(long idBloc) { blocRepository.deleteById(idBloc); }

    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bloc introuvable: id=" + idBloc));

        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        for (Chambre ch : chambres) {
            ch.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);
        return bloc;
    }

    @Override
    public List<Bloc> getBlocsByNomUniversite(String nomUniversite) {
        return blocRepository.findByFoyerUniversiteNomUniversite(nomUniversite);
    }


}
