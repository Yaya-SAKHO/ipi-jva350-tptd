package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;


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


    @Test
    void testcClculeJoursDeCongeDecomptesPourPlage() {

        SalarieAideADomicile sal = new SalarieAideADomicile("Yaya",LocalDate.of(2021,7,1),
                LocalDate.now(), 0,0,
                9,1,0);
        //When
        LinkedHashSet<LocalDate> res = sal.calculeJoursDeCongeDecomptesPourPlage(LocalDate.of(2022,7,1),LocalDate.of(2022,7,2));

        //Then
        LinkedHashSet<LocalDate> expected = new LinkedHashSet<>();
        expected.add(LocalDate.of(2022,7,2));
        expected.add(LocalDate.parse("2022-07-01"));
        Assertions.assertEquals(expected,res);

    }


    @ParameterizedTest(name = "numeroSecu {0} est valide : {1}")
    @CsvSource({
            "'2022-07-01','2022-07-02',2",
            "'2022-07-01','2022-07-03',2",
            "'2022-07-02','2022-07-04',1",
            "'2022-07-02','2022-07-02',0"
    })
    void testcClculeJoursDeCongeDecomptesPourPlageParametre(String debut,String fin, double expecteNbJoursDeCongerDeCompte) {

        SalarieAideADomicile sal = new SalarieAideADomicile("Yaya",LocalDate.of(2021,7,1),
                LocalDate.now(), 0,0,
                10,1,0);
        //When
        LinkedHashSet<LocalDate> res = sal.calculeJoursDeCongeDecomptesPourPlage(
                LocalDate.parse(debut),LocalDate.parse(fin));

        //Then
        Assertions.assertEquals(expecteNbJoursDeCongerDeCompte,res.size());
        

    }
}