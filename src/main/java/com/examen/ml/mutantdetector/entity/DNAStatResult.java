package com.examen.ml.mutantdetector.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Digits;

@Data
public class DNAStatResult {

    @JsonProperty(value = "count_mutant_dna")
    private Long countMutantDna;
    @JsonProperty(value = "count_human_dna")
    private Long countHumanDna;

    public DNAStatResult(DNAStats dnaStats){
        this.countMutantDna= dnaStats.getCountMutantDna();
        this.countHumanDna= dnaStats.getCountHumanDna();
    }

    public Float getRatio(){
        if(getCountHumanDna()!=null &&  getCountHumanDna()>0)
            return getCountMutantDna().floatValue()/getCountHumanDna().floatValue();
        return null;
    }
}
