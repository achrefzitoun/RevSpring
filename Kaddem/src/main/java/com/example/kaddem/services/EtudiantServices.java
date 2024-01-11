package com.example.kaddem.services;

import com.example.kaddem.entities.Contrat;
import com.example.kaddem.entities.Departement;
import com.example.kaddem.entities.Equipe;
import com.example.kaddem.entities.Etudiant;
import com.example.kaddem.repositories.IContratRepository;
import com.example.kaddem.repositories.IDepartementRepository;
import com.example.kaddem.repositories.IEquipeRepository;
import com.example.kaddem.repositories.IEtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EtudiantServices implements IEtudiantServices{

    private final IEtudiantRepository etudiantRepository;
    private final IDepartementRepository departementRepository;
    private final IContratRepository contratRepository;
    private final IEquipeRepository equipeRepository;

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement dep = departementRepository.findById(idDepartement).orElse(null);
        return etudiantRepository.findByDepartement(dep);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat c = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        c.setEtudiant(e);
        if(e.getEquipes()==null){
            Set<Equipe> eq = new HashSet<>();
            eq.add(equipe);
            e.setEquipes(eq);
        }
        else {
            e.getEquipes().add(equipe);
        }
        contratRepository.save(c);
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant asignEtudToDep(Integer idStudent, Integer idDep) {
        Departement departement = departementRepository.findById(idDep).orElse(null);
        Etudiant etudiant = etudiantRepository.findById(idStudent).orElse(null);
        etudiant.setDepartement(departement);
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiantRepository.findAll().forEach(etudiants::add);
        return etudiants;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public Etudiant findDistinctFirstByNomEAndPrenomE(String nom, String prenom) {
        return etudiantRepository.findDistinctFirstByNomEAndPrenomE(nom,prenom);
    }

    @Override
    public void removeEtudiant(Integer idEtudient) {
        etudiantRepository.deleteById(idEtudient);
    }
}
