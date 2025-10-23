package tn.esprit.spring.gestionfoyerchedly.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idReservation;
    Date anneeUniversitaire;
    boolean estValide;

    @ManyToMany(mappedBy = "reservations")
    @JsonIgnore
    List<Etudiant> etudiants;

    @ManyToMany(mappedBy = "reservations")
    @JsonIgnore
    List<Chambre> chambres;
}
