package com.example.datacenter.repositories;

import com.example.datacenter.entities.Datacenter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface IDatacenterRepository extends CrudRepository<Datacenter, Integer> {

    List<Datacenter> findDatacentersByDateFabricationIsAfter(Date d1);
}
