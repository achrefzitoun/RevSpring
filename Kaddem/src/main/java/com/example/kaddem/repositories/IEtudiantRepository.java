package com.example.kaddem.repositories;

import com.example.kaddem.entities.Departement;
import com.example.kaddem.entities.Etudiant;
import com.example.kaddem.entities.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant, Integer> {

    Etudiant findDistinctFirstByNomEAndPrenomE(String nomE, String prenomE);

    @Query("select e from Etudiant e where e.departement = ?1")
    List<Etudiant> findByDepartement(Departement departement);

}
