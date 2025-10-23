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
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUniversite;
    String nomUniversite;
    String adresse;

    @OneToOne
    Foyer foyer;
}
