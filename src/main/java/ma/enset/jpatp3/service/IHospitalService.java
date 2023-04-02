package ma.enset.jpatp3.service;

import ma.enset.jpatp3.entities.Consultation;
import ma.enset.jpatp3.entities.Medecin;
import ma.enset.jpatp3.entities.Patient;
import ma.enset.jpatp3.entities.RendezVous;

public interface IHospitalService  {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
