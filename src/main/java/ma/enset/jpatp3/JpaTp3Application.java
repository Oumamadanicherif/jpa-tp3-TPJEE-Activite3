package ma.enset.jpatp3;

import ma.enset.jpatp3.entities.Patient;
import ma.enset.jpatp3.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaTp3Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaTp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(
                new Patient(null,"Oumaima",new Date(),false,50)
        );
        patientRepository.save(
                new Patient(null,"Salim",new Date(),true,100)
        );
        patientRepository.save(
                new Patient(null,"Ahmed",new Date(),false,230)
        );
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(patient -> {
            System.out.println("===============================================");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaissanec());
            System.out.println(patient.isMalade());
        });
        System.out.println("********************************************");
        Patient patient=patientRepository.findById(1L).orElse(null);
        if(patient !=null){
            System.out.println(patient.isMalade());
            System.out.println(patient.getNom());
        }
        patient.setScore(870);
        patientRepository.save(patient);

    }
}
