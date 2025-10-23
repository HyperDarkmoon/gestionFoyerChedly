package tn.esprit.spring.gestionfoyerchedly.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEtudiant;
    String nomEtudiant;
    String prenomEtudiant;
    long cin;
    String ecole;
    Date dateNaissance;

    @ManyToMany
    @JoinTable(
            name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "idEtudiant"),
            inverseJoinColumns = @JoinColumn(name = "idReservation")
    )
    List<Reservation> reservations;
}
