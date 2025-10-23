package tn.esprit.spring.gestionfoyerchedly.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.List;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idReservation;
    Date anneeUniversitaire;
    boolean estValide;

    @ManyToMany(mappedBy = "reservations")
    List<Etudiant> etudiants;

    @ManyToMany(mappedBy = "reservations")
    List<Chambre> chambres;
}
