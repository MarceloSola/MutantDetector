package com.examen.ml.mutantdetector.endpoint;

import com.examen.ml.mutantdetector.business.DNAMutantValidator;
import com.examen.ml.mutantdetector.entity.DNARequest;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

@RestController
@Api(value = "Servicio Validador de ADN Mutante", description = "Este servicio permite validar si el ADN dado es mutante", tags = {"Validador de ADN Mutante"})
public class MutantDetectorController {

    @PostMapping(value = "/mutant", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Punto de entrada del validador", notes="Este servicio permite validar si el ADN dado es mutante")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mutante"),
            @ApiResponse(code = 403, message = "No mutante")
    })
    public ResponseEntity mutant(@RequestBody @ApiParam(value = "Contenedor de ADN", required = true) DNARequest dnaRequest){
        if(!(new DNAMutantValidator()).isMutant(dnaRequest.getDna()))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        return ResponseEntity.ok().body(null);
    }

}
