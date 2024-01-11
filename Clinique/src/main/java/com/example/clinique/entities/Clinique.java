package com.example.clinique.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clinique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClinique;

    String nonClinique;

    String adresse;

    Integer telephone;

    @ManyToMany
    Set<Medecin> medecins;

    @OneToOne
    Clinique clinique;
}
