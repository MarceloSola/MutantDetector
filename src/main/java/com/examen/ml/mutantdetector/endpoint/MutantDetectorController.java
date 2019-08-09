package com.examen.ml.mutantdetector.endpoint;

import com.examen.ml.mutantdetector.business.DNAMutantValidator;
import com.examen.ml.mutantdetector.entity.DNARequest;
import com.examen.ml.mutantdetector.entity.DNAStatResult;
import com.examen.ml.mutantdetector.entity.DNAStats;
import com.examen.ml.mutantdetector.entity.DNAValidationReg;
import com.examen.ml.mutantdetector.repository.DNARepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Servicio Validador de ADN Mutante", description = "Este servicio permite validar si el ADN dado es mutante", tags = {"Validador de ADN Mutante"})
public class MutantDetectorController {

    @Autowired
    private DNARepository dnaRepository;

    @PostMapping(value = "/mutant", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Punto de entrada del validador", notes="Este servicio permite validar si el ADN dado es mutante")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mutante"),
            @ApiResponse(code = 403, message = "No mutante")
    })
    public ResponseEntity mutant(@RequestBody @ApiParam(value = "Contenedor de ADN", required = true) DNARequest dnaRequest){
        boolean isMutant = (new DNAMutantValidator()).isMutant(dnaRequest.getDna());
        dnaRepository.save(new DNAValidationReg(dnaRequest, isMutant));
        if(isMutant)
            return ResponseEntity.ok().body(null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public DNAStatResult stats(){
        return new DNAStatResult(dnaRepository.getStatsRepo());
    }
}
