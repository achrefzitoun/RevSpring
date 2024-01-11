package com.example.datacenter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Datacenter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idDs;

    String region;

    @Temporal(TemporalType.DATE)
    Date dateFabrication;

    Integer capaciteDisque,espaceLibreDisque;

    @OneToMany(mappedBy = "datacenter")
    Set<VirtualMachine> virtualMachines;
}
