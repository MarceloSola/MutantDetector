package com.examen.ml.mutantdetector.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ToString
public class DNAValidationReg {

    @Id
    private DNARequest dnaRequest;
    private boolean isMutant;

    public DNAValidationReg(DNARequest dnaRequest, boolean isMutant){
        this.dnaRequest=dnaRequest;
        this.isMutant=isMutant;
    }


}
