package com.example.clinique.repositories;

import com.example.clinique.entities.Clinique;
import com.example.clinique.entities.Medecin;
import com.example.clinique.entities.Specialite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IMedecinRepository extends CrudRepository<Medecin, Long> {
}
