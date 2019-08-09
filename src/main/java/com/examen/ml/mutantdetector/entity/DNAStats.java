package com.examen.ml.mutantdetector.entity;

import lombok.Data;

@Data
public class DNAStats {

    private Long countMutantDna;
    private Long countHumanDna;

    public Float getRatio(){
        if(getCountHumanDna()>0)
            return Float.valueOf(getCountMutantDna()/getCountHumanDna());
        return null;
    }
}
