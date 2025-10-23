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
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    String nomBloc;
    long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "idFoyer")
    Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    List<Chambre> chambres;
}
