package com.example.clinique.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
/*
    @Before(" execution(* com.example.clinique.services.CliniqueServices.*(..)) ")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
*/
    @After(" execution(* com.example.clinique.services.*.add*(..)) ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("méthode exécutée");
    }
/*
    @After(" execution(* com.example.clinique.services.CliniqueServices.addMedecinAndAssignToClinique(..)) ")
    public void logMethodExit1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("méthode exécutée");
    }

    @After(" execution(* com.example.clinique.services.CliniqueServices.addPatient(..)) ")
    public void logMethodExit2(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("méthode exécutée");
    }

    @After(" execution(* com.example.clinique.services.CliniqueServices.addRDVAndAssignMedAndPatient(..)) ")
    public void logMethodExit3(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("méthode exécutée");
    }

    @Around(" execution(* com.example.clinique.services.CliniqueServices.*(..)) ")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime
                +"milliseconds.");
        return obj;
    }
*/

}
