# MutantDetector
Detector de ADN Mutante Ejercicio

Este es un ejercicio para demostrar conceptos basicos de un servicio REST con cierta complejidad de negocio. Basicamente este servicio recibe un mapa de ADN en una grilla de NxN formada por 4 tipo de letras (A,T,C,G). Se determina que una ADN es mutante, si contiene mas de una cadena de 4 letras continuas repetidas en cualquier direccion. Este servicio REST permite identificar si el ADN es mutante o no.

## Navegar Detalles del Servicio

https://mutant-detector-ml.herokuapp.com/swagger-ui.html#/mutant-detector-controller/mutantUsingPOST

Ejemplos

ADN Humano
{
"dna":["AGTCGA","GTCAGA","GATGCG","GGACTA","GATACG","AGTCGA"]
}

ADN Mutante
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
