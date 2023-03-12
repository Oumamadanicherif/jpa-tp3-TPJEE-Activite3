package ma.enset.jpatp3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column (length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissanec;
    private boolean malade;
    private int score;
    // @Data automatiquement ajout getters and setters
    //@NoArgsConstructor constructeur sans parametre
    //@AllArgsConstrctor constructeur avec parametre

}
