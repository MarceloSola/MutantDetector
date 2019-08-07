package com.examen.ml.mutantdetector.endpoint;

import com.examen.ml.mutantdetector.business.DNAMutantValidator;
import com.examen.ml.mutantdetector.entity.DNARequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantDetectorController {

    @RequestMapping("/mutant")
    @PostMapping
    public boolean mutant(DNARequest dnaRequest){
        return (new DNAMutantValidator()).isMutant(dnaRequest.getDna());
    }
}
