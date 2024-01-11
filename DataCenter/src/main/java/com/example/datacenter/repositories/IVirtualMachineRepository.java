package com.example.datacenter.repositories;

import com.example.datacenter.entities.VirtualMachine;
import org.springframework.data.repository.CrudRepository;

public interface
IVirtualMachineRepository extends CrudRepository<VirtualMachine, Integer> {
}
