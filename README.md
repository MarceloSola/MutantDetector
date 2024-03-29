# MutantDetector
Detector de ADN Mutante Ejercicio

Este es un ejercicio para demostrar conceptos basicos de un servicio REST con cierta complejidad de negocio. Basicamente este servicio recibe un mapa de ADN en una grilla de NxN formada por 4 tipo de letras (A,T,C,G). Se determina que una ADN es mutante, si contiene mas de una cadena de 4 letras continuas repetidas en cualquier direccion. Este servicio REST permite identificar si el ADN es mutante o no.


## Requerimientos

* JDK 1.8
* Maven 3.3.9
* Lombok 1.18.8 (Para IDE)

## Compilacion

mvn clean install

## Ejecucion
Definir datos de conexion a la Postgre usando variabls en entorno o como parametro del sistema en el comando de ejecucion con los siguientes nombres

    * JDBC_DATABASE_URL
    * JDBC_DATABASE_USERNAME
    * JDBC_DATABASE_PASSWORD

### Usando java
java -jar target/mutant-detector-1.0-SNAPSHOT.jar

### Usando maven
mvn spring-boot:run

# Consumir la API

La implementacion esta deployada en mutant-detector-ml.herokuapp.com. En caso de usar la version local, hay que reemplazar por localhost:8080

## Navegar Detalles del Servicio (permite evaluar las APIs)

https://mutant-detector-ml.herokuapp.com/swagger-ui.html#/Validador_de_ADN_Mutante

## Ejecutar validador desde CURL 

curl -X POST "https://mutant-detector-ml.herokuapp.com/mutant" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"] }"

## Ejecutar reporte desde CURL

curl -X GET "https://mutant-detector-ml.herokuapp.com/stats" -H "accept: application/json"

### Directamente desde el Browser

https://mutant-detector-ml.herokuapp.com/stats

## Ejemplos

ADN Humano
{
"dna":["AGTCGA","GTCAGA","GATCCG","TGACTA","GATCCG","AGTCGA"]
}

ADN Mutante
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
