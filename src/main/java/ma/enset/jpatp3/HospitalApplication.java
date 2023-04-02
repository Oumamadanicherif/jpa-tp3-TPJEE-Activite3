package ma.enset.jpatp3;
import ma.enset.jpatp3.entities.*;
import ma.enset.jpatp3.repositories.ConsultationRepository;
import ma.enset.jpatp3.repositories.MedecinRepository;
import ma.enset.jpatp3.repositories.PatientRepository;
import ma.enset.jpatp3.repositories.RendezVousRepository;
import ma.enset.jpatp3.service.IHospitalService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication{
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService iHospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("Mohammed","Hassan","Oumaima")
                    .forEach(name ->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissanec(new Date());
                        patient.setMalade(false);
                        iHospitalService.savePatient(patient);
                    });
            Stream.of("Rajae","Salim","Amina")
                    .forEach(name ->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        iHospitalService.saveMedecin(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1= patientRepository.findByNom("Mohammed");

            Medecin medecin= medecinRepository.findByNom("Rajae");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveRDV = iHospitalService.saveRDV(rendezVous);

            System.out.println(saveRDV.getId());

            RendezVous rendezVous1= rendezVousRepository.findAll().get(0);
            Consultation consultation= new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation .....");
            iHospitalService.saveConsultation(consultation);

        };

    }
}
