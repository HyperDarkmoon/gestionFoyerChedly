package tn.esprit.spring.gestionfoyerchedly.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tn.esprit.spring.gestionfoyerchedly.Entity.*;
import tn.esprit.spring.gestionfoyerchedly.Repository.*;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Seeds mock data for all entities at application startup (non-test profiles only).
 * The seeding runs only when repositories are empty to avoid duplicate data.
 */
@Component
@Profile("!test")
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;
    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;
    private final EtudiantRepository etudiantRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public void run(String... args) {
        // Avoid reseeding if data already exists
        long univCount = universiteRepository.count();
        long foyerCount = foyerRepository.count();
        long blocCount = blocRepository.count();
        long chambreCount = chambreRepository.count();
        long etuCount = etudiantRepository.count();
        long resCount = reservationRepository.count();

        log.info("[Seed] Current counts -> Universite: {}, Foyer: {}, Bloc: {}, Chambre: {}, Etudiant: {}, Reservation: {}",
                univCount, foyerCount, blocCount, chambreCount, etuCount, resCount);

        // Idempotent guard: if at least one university exists, assume data already seeded.
        if (univCount > 0) {
            log.info("[Seed] Skipping seeding because Universite data already exists.");
            return;
        }

        log.info("[Seed] Seeding initial mock data...");

        // Create Foyers first (since Universite owns the OneToOne relation)
        Foyer foyerEsprit = new Foyer();
        foyerEsprit.setNomFoyer("Foyer ESPRIT");
        foyerEsprit.setCapaciteFoyer(500);
        foyerEsprit.setBlocs(new ArrayList<>());
        foyerEsprit = foyerRepository.save(foyerEsprit);

        Foyer foyerEnis = new Foyer();
        foyerEnis.setNomFoyer("Foyer ENIS");
        foyerEnis.setCapaciteFoyer(300);
        foyerEnis.setBlocs(new ArrayList<>());
        foyerEnis = foyerRepository.save(foyerEnis);

        // Create Universites and link to Foyers (owning side is Universite)
        Universite esprit = new Universite();
        esprit.setNomUniversite("ESPRIT");
        esprit.setAdresse("Ariana, Tunis");
        esprit.setFoyer(foyerEsprit);
        esprit = universiteRepository.save(esprit);
        foyerEsprit.setUniversite(esprit);
        foyerRepository.save(foyerEsprit);

        Universite enis = new Universite();
        enis.setNomUniversite("ENIS");
        enis.setAdresse("Sfax, Tunisia");
        enis.setFoyer(foyerEnis);
        enis = universiteRepository.save(enis);
        foyerEnis.setUniversite(enis);
        foyerRepository.save(foyerEnis);

        // Create Blocs and associate to Foyers
        Bloc blocA = new Bloc();
        blocA.setNomBloc("Bloc A");
        blocA.setCapaciteBloc(200);
        blocA.setFoyer(foyerEsprit);
        blocA.setChambres(new ArrayList<>());
        blocA = blocRepository.save(blocA);

        Bloc blocB = new Bloc();
        blocB.setNomBloc("Bloc B");
        blocB.setCapaciteBloc(300);
        blocB.setFoyer(foyerEsprit);
        blocB.setChambres(new ArrayList<>());
        blocB = blocRepository.save(blocB);

        Bloc blocC = new Bloc();
        blocC.setNomBloc("Bloc C");
        blocC.setCapaciteBloc(150);
        blocC.setFoyer(foyerEnis);
        blocC.setChambres(new ArrayList<>());
        blocC = blocRepository.save(blocC);

        // Create Chambres and associate to Blocs
        Chambre c101 = chambre(101, TypeChambre.SIMPLE, blocA);
        Chambre c102 = chambre(102, TypeChambre.DOUBLE, blocA);
        Chambre c103 = chambre(103, TypeChambre.TRIPLE, blocA);
        Chambre c201 = chambre(201, TypeChambre.SIMPLE, blocB);
        Chambre c202 = chambre(202, TypeChambre.DOUBLE, blocB);
        Chambre c203 = chambre(203, TypeChambre.TRIPLE, blocB);
        Chambre c301 = chambre(301, TypeChambre.SIMPLE, blocC);
        Chambre c302 = chambre(302, TypeChambre.DOUBLE, blocC);

    chambreRepository.saveAll(Arrays.asList(
        c101, c102, c103, c201, c202, c203, c301, c302
    ));

        // Update blocs' chambre lists (inverse side) for in-memory consistency
        blocA.getChambres().addAll(Arrays.asList(c101, c102, c103));
        blocB.getChambres().addAll(Arrays.asList(c201, c202, c203));
        blocC.getChambres().addAll(Arrays.asList(c301, c302));
        blocRepository.saveAll(Arrays.asList(blocA, blocB, blocC));

        // Create Etudiants
        Etudiant e1 = etudiant("Ali", "Ben Salah", 12345678L, "ESPRIT", date(2000, Calendar.JANUARY, 15));
        Etudiant e2 = etudiant("Mariem", "Trabelsi", 23456789L, "ENIS", date(1999, Calendar.MAY, 20));
        Etudiant e3 = etudiant("Sami", "Gharbi", 34567890L, "ENIT", date(2001, Calendar.SEPTEMBER, 10));
        etudiantRepository.saveAll(Arrays.asList(e1, e2, e3));

        // Create Reservations
        Reservation r1 = new Reservation();
        r1.setAnneeUniversitaire(new Date());
        r1.setEstValide(true);
        r1.setEtudiants(new ArrayList<>());
        r1.setChambres(new ArrayList<>());
        r1 = reservationRepository.save(r1);

        Reservation r2 = new Reservation();
        r2.setAnneeUniversitaire(new Date());
        r2.setEstValide(false);
        r2.setEtudiants(new ArrayList<>());
        r2.setChambres(new ArrayList<>());
        r2 = reservationRepository.save(r2);

        // Link Reservations to Etudiants (owning side: Etudiant)
        e1.setReservations(new ArrayList<>(Collections.singletonList(r1)));
        e2.setReservations(new ArrayList<>(Collections.singletonList(r1)));
        e3.setReservations(new ArrayList<>(Collections.singletonList(r2)));
        etudiantRepository.saveAll(Arrays.asList(e1, e2, e3));

        // Link Reservations to Chambres (owning side: Chambre)
        addReservationToChambre(c101, r1);
        addReservationToChambre(c202, r1);
        addReservationToChambre(c201, r2);
        chambreRepository.saveAll(Arrays.asList(c101, c202, c201));
        log.info("[Seed] Seeding complete.");
    }

    private static Chambre chambre(long numero, TypeChambre type, Bloc bloc) {
        Chambre c = new Chambre();
        c.setNumeroChambre(numero);
        c.setTypeC(type);
        c.setBloc(bloc);
        c.setReservations(new ArrayList<>());
        return c;
    }

    private static Etudiant etudiant(String nom, String prenom, long cin, String ecole, Date dateNaissance) {
        Etudiant e = new Etudiant();
        e.setNomEtudiant(nom);
        e.setPrenomEtudiant(prenom);
        e.setCin(cin);
        e.setEcole(ecole);
        e.setDateNaissance(dateNaissance);
        e.setReservations(new ArrayList<>());
        return e;
    }

    private static Date date(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private static void addReservationToChambre(Chambre chambre, Reservation reservation) {
        if (chambre.getReservations() == null) {
            chambre.setReservations(new ArrayList<>());
        }
        chambre.getReservations().add(reservation);
        if (reservation.getChambres() == null) {
            reservation.setChambres(new ArrayList<>());
        }
        reservation.getChambres().add(chambre);
    }
}
