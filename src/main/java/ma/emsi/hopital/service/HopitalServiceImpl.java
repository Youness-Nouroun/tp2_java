package ma.emsi.hopital.service;

import jakarta.transaction.Transactional;
import ma.emsi.hopital.entities.Consultation;
import ma.emsi.hopital.entities.Medecin;
import ma.emsi.hopital.entities.Patient;
import ma.emsi.hopital.entities.RendezVous;
import ma.emsi.hopital.repositories.ConsultationRepository;
import ma.emsi.hopital.repositories.MedecinRepository;
import ma.emsi.hopital.repositories.PatientRepository;
import ma.emsi.hopital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HopitalServiceImpl implements IHopitalService {
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;

    public HopitalServiceImpl(RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository, MedecinRepository medecinRepository, PatientRepository patientRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
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
