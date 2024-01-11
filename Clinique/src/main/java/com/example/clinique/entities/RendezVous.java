package com.example.clinique.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRDV;

    @Temporal(TemporalType.DATE)
    Date dateRDV;

    String remarque;

    @ManyToOne
    @JsonIgnore
    Medecin medecin;

    @ManyToOne
    @JsonIgnore
    Patient patient;
}
