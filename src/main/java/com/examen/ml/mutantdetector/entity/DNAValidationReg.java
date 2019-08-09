package com.examen.ml.mutantdetector.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DNAValidations")
@ToString
public class DNAValidationReg {

    @Id
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private DNARequest dnaRequest;
    private boolean isMutant;

    public DNAValidationReg(DNARequest dnaRequest, boolean isMutant){
        this.dnaRequest=dnaRequest;
        this.isMutant=isMutant;
    }


}
