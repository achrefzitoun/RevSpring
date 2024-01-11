package com.example.clinique.entities;

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
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPatent;

    String nomPatient;

    Integer telephone;

    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    @OneToMany(mappedBy = "patient")
    Set<RendezVous> rendezVous;
}
