package ma.enset.jpatp3.repositories;

import ma.enset.jpatp3.entities.Patient;
import ma.enset.jpatp3.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {

}
