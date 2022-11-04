package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class SalarieAideADomicileTest {

    @Test
    void aLegalementDroitADesCongesPayesFalse() {

        //Given
        SalarieAideADomicile sal = new SalarieAideADomicile();
        //When
        boolean res = sal.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false,res);
    }

    @Test
    void aLegalementDroitADesCongesPayesTrues(){

        //Given
        SalarieAideADomicile sal = new SalarieAideADomicile("Yaya",LocalDate.now(),LocalDate.now(),0,0,5,1,0);
        //When
        boolean res = sal.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false,res);
    }

    @Test
    void aLegalementDroitADesCongesPayesOinsde10(){

        //Given
        SalarieAideADomicile sal = new SalarieAideADomicile("Yaya",LocalDate.of(2021,7,1),
                LocalDate.now(), 0,0,
                5,1,0);
        //When
        boolean res = sal.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false,res);
    }

    @Test
    void aLegalementDroitADesCongesPayesNeteentlus10(){

        //Given
        SalarieAideADomicile sal = new SalarieAideADomicile("Yaya",LocalDate.of(2021,7,1),
                LocalDate.now(), 0,0,
                15,1,0);
        //When
        boolean res = sal.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(true,res);
    }

    @Test
    void aLegalementDroitADesCongesPayesliite10(){

        //Given
        SalarieAideADomicile sal = new SalarieAideADomicile("Yaya",LocalDate.of(2021,7,1),
                LocalDate.now(), 0,0,
                10,1,0);
        //When
        boolean res = sal.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(true,res);
    }

    @Test
    void aLegalementDroitADesCongesPayesliite9(){

        //Given
        SalarieAideADomicile sal = new SalarieAideADomicile("Yaya",LocalDate.of(2021,7,1),
                LocalDate.now(), 0,0,
                9,1,0);
        //When
        boolean res = sal.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(false,res);
    }

}