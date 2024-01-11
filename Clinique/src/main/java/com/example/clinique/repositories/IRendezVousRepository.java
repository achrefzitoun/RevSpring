package com.example.clinique.repositories;

import com.example.clinique.entities.Medecin;
import com.example.clinique.entities.RendezVous;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRendezVousRepository extends CrudRepository<RendezVous, Long> {
    Integer countByMedecin(Medecin medecin);

}
