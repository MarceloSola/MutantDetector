package com.examen.ml.mutantdetector.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

@Data
@ApiModel()
@ToString
public class DNARequest {
    private String[] dna;
}
