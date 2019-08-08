package com.examen.ml.mutantdetector.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DNAMutantValidatorTest {

    private DNAMutantValidator dnaMutantValidator;
    private String[] dnaMutante={"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    private String[] dnaHumano={"AGTCGA","GTCAGA","GATGCG","GGACTA","GATACG","AGTCGA"};

    @Before
    public void setUp() throws Exception {
        dnaMutantValidator = new DNAMutantValidator();
    }

    @Test
    public void isMutantOK() {
        assertTrue(dnaMutantValidator.isMutant(dnaMutante));
    }

    @Test
    public void isMutantFail(){
        assertFalse(dnaMutantValidator.isMutant(dnaHumano));
    }
}