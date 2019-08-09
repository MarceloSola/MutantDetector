package com.examen.ml.mutantdetector.repository;

import com.examen.ml.mutantdetector.entity.DNARequest;
import com.examen.ml.mutantdetector.entity.DNAStats;
import com.examen.ml.mutantdetector.entity.DNAValidationReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<DNAValidationReg, String> {

    //@Query("SELECT new com.examen.ml.mutantdetector.entity.DNAStats(CASE WHEN ")
    //DNAStats getStatsRepo();
}
