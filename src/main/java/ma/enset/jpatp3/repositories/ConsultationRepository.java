package ma.enset.jpatp3.repositories;

import ma.enset.jpatp3.entities.Consultation;
import ma.enset.jpatp3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
