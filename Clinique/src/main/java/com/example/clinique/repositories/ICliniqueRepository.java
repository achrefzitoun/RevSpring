package com.example.clinique.repositories;

import com.example.clinique.entities.Clinique;
import com.example.clinique.entities.Medecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliniqueRepository extends CrudRepository<Clinique, Long> {

}
