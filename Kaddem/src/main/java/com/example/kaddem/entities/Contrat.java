package com.example.kaddem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContrat;

    @Temporal(TemporalType.DATE)
    Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    Date dateFinContrat;

    @Enumerated(EnumType.STRING)
    Specialite specialite;

    Boolean archive;

    Integer montantContrat;

    @ManyToOne
    Etudiant etudiant;
}
