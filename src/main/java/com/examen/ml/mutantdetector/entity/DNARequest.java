package com.examen.ml.mutantdetector.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel()
public class DNARequest {
    private String[] dna;
}
