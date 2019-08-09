package com.examen.ml.mutantdetector.repository;

import com.examen.ml.mutantdetector.entity.DNAStats;
import com.examen.ml.mutantdetector.entity.DNAValidationReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<DNAValidationReg, String> {

    @Query(value = "SELECT count_mutant_dna as CountMutantDna, count_human_dna as CountHumanDna from DNA_Stats_VW", nativeQuery = true)
    DNAStats getStatsRepo();
}
