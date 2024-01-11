package com.example.kaddem.repositories;

import com.example.kaddem.entities.Contrat;
import com.example.kaddem.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IContratRepository extends CrudRepository<Contrat, Integer> {
    Integer countByArchiveIsFalseAndEtudiant(Etudiant e);

    Integer countByArchiveIsFalseAndDateDebutContratBetween(Date d1, Date d2);

}
