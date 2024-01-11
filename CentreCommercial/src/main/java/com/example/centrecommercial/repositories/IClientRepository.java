package com.example.centrecommercial.repositories;

import com.example.centrecommercial.entities.Client;
import com.example.centrecommercial.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends CrudRepository<Client, Long> {
    int countByGenre(Genre genre);
}
