package ma.enset.jpatp3.repositories;

import ma.enset.jpatp3.entities.Medecin;
import ma.enset.jpatp3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom (String nom);
}
