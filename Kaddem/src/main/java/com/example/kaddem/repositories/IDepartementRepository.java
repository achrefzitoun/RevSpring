package com.example.kaddem.repositories;

import com.example.kaddem.entities.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartementRepository extends CrudRepository<Departement, Integer> {

}
