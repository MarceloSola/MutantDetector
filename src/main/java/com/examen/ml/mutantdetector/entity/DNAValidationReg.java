package com.examen.ml.mutantdetector.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DNAValidations")
@ToString
@NoArgsConstructor
public class DNAValidationReg {

    @Id
    private String dnaRequest;
    private boolean isMutant;

    public DNAValidationReg(DNARequest dnaRequest, boolean isMutant){
        this.dnaRequest=dnaRequest.toString();
        this.isMutant=isMutant;
    }


}
