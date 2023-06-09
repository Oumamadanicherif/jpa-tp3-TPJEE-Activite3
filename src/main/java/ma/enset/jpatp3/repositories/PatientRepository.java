package ma.enset.jpatp3.repositories;

import ma.enset.jpatp3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
     Patient findByNom(String name);
}
