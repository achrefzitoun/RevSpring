package com.example.kaddem.services;

import com.example.kaddem.entities.Contrat;
import com.example.kaddem.entities.Etudiant;
import com.example.kaddem.repositories.IContratRepository;
import com.example.kaddem.repositories.IEtudiantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ContratServices implements IContratServices{

    private final IContratRepository contratRepository;

    private final IEtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> ce = new ArrayList<>();
        contratRepository.findAll().forEach(ce::add);
        return ce;
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.findDistinctFirstByNomEAndPrenomE(nomE,prenomE);
        if(contratRepository.countByArchiveIsFalseAndEtudiant(e)<5 ){
            ce.setEtudiant(e);
            contratRepository.save(ce);
        }
        return ce;
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(new Contrat());
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.countByArchiveIsFalseAndDateDebutContratBetween(startDate, endDate);
    }

    @Override
    @Scheduled(cron = "1/5 * * * * *")
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> contrats = retrieveAllContrats();
        Date d = new Date();
        for(Contrat c : contrats){
            if(!c.getArchive() && c.getDateFinContrat().getYear()-d.getYear()==0 && c.getDateFinContrat().getMonth()-d.getMonth()==0 && c.getDateFinContrat().getDay()-d.getDay()<=15 ){
                if(c.getDateFinContrat().equals(d)){
                    c.setArchive(true);
                    contratRepository.save(c);
                }else{

                    System.out.println("==============");
                    System.out.println("Date debut contrat : "+c.getDateDebutContrat());
                    System.out.println("Date fin contrat : "+c.getDateFinContrat());
                    System.out.println("Spécialité : "+c.getSpecialite());
                }
            }
        }

    }
}
