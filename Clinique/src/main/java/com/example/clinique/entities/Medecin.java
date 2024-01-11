package com.example.clinique.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMedecin;

    String nomMedecin;

    @Enumerated(EnumType.STRING)
    Specialite specialite;

    Integer telephone;

    Integer prixConsultation;

    @ManyToMany(mappedBy = "medecins")
    Set<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    Set<RendezVous> rendezVous;
}
