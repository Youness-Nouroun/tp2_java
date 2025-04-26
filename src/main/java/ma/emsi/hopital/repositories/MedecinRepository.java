package ma.emsi.hopital.repositories;

import ma.emsi.hopital.entities.Medecin;
import ma.emsi.hopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}

