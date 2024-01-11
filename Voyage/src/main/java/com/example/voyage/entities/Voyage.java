package com.example.voyage.entities;

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
public class Voyage implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idVoyage;

    Long codeVille;

    @Enumerated(EnumType.STRING)
    Ville gareDepart;

    @Enumerated(EnumType.STRING)
    Ville gareArrivee;

    Double heureDepart;

    Double heureArrivee;

    @Temporal(TemporalType.DATE)
    Date dateDepart;

    @Temporal(TemporalType.DATE)
    Date dateArrivee;

    @ManyToMany
    Set<Voyageur> voyageurs;

    @ManyToOne(cascade = CascadeType.ALL)
    Train train;



}
