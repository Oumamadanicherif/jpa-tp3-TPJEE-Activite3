package ma.enset.jpatp3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissanec;
    private boolean malade;
    @OneToMany (mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
//    @DecimalMin("100")
//    private int score;
    // @Data automatiquement ajout getters and setters
    //@NoArgsConstructor constructeur sans parametre
    //@AllArgsConstrctor constructeur avec parametre

}
