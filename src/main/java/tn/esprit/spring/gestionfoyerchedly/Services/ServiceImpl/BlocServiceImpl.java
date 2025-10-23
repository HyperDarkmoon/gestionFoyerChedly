package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import tn.esprit.spring.gestionfoyerchedly.Repository.BlocRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IBlocService;

import java.util.List;

@Service
@Transactional
public class BlocServiceImpl implements IBlocService {
    private final BlocRepository blocRepository;

    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
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
}
