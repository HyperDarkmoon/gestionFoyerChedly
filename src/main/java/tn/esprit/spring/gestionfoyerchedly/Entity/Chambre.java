package tn.esprit.spring.gestionfoyerchedly.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;
    long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeC;

    @ManyToOne
    @JoinColumn(name = "idBloc")
    Bloc bloc;

    @ManyToMany
    @JoinTable(
            name = "chambre_reservation",
            joinColumns = @JoinColumn(name = "idChambre"),
            inverseJoinColumns = @JoinColumn(name = "idReservation")
    )
    List<Reservation> reservations;
}
