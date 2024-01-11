package com.example.centrecommercial.repositories;

import com.example.centrecommercial.entities.CentreCommercial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICentreCommercialRepository  extends CrudRepository<CentreCommercial, Long> {
}
