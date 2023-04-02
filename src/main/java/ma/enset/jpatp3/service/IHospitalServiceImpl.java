package ma.enset.jpatp3.service;

import jakarta.transaction.Transactional;
import ma.enset.jpatp3.entities.Consultation;
import ma.enset.jpatp3.entities.Medecin;
import ma.enset.jpatp3.entities.Patient;
import ma.enset.jpatp3.entities.RendezVous;
import ma.enset.jpatp3.repositories.ConsultationRepository;
import ma.enset.jpatp3.repositories.MedecinRepository;
import ma.enset.jpatp3.repositories.PatientRepository;
import ma.enset.jpatp3.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl() {
    }

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
