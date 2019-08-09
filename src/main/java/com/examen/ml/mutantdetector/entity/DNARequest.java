package com.examen.ml.mutantdetector.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ApiModel()
@ToString
public class DNARequest implements Serializable {
    private String[] dna;
}
