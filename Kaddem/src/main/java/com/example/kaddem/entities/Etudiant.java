package com.example.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEtudiant;

    String prenomE;

    String nomE;

    @Enumerated(EnumType.STRING)
    Option option;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    Set<Equipe> equipes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    Departement departement;

    @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    Set<Contrat> contrats;
}
