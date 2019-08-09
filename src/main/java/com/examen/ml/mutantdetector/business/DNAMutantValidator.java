package com.examen.ml.mutantdetector.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DNAMutantValidator {

    Logger log = LoggerFactory.getLogger(DNAMutantValidator.class);

    public boolean isMutant(String[] dna) {
        log.info("Mutant Validation Request");
        int[][] quantH=new int[dna[0].length()][dna.length];
        int[][] quantV=new int[dna[0].length()][dna.length];
        int[][] quantDR=new int[dna[0].length()][dna.length];
        int[][] quantDL=new int[dna[0].length()][dna.length];
        int grupoDetectado=0;
        for(int y=0;y<dna.length;y++){
            for(int x=0;x<dna[0].length();x++){
                if(x>0){
                    if(dna[y].charAt(x)==dna[y].charAt(x-1)){
                        quantH[x][y]+=quantH[x-1][y]+1;
                        if(detectaLimpia(quantH,x,y)){
                            grupoDetectado++;
                        }
                    }
                }
                if(y>0){
                    if(dna[y].charAt(x)==dna[y-1].charAt(x)){
                        quantV[x][y]+=quantV[x][y-1]+1;
                        if(detectaLimpia(quantV,x,y)){
                            grupoDetectado++;
                        }
                    }
                }
                if(x>0 && y>0){
                    if(dna[y].charAt(x)==dna[y-1].charAt(x-1)){
                        quantDR[x][y]+=quantDR[x-1][y-1]+1;
                        if(detectaLimpia(quantDR,x,y)){
                            grupoDetectado++;
                        }
                    }
                }
                if(y>0 && x<dna[y].length()-1){
                    if(dna[y].charAt(x)==dna[y-1].charAt(x+1)){
                        quantDL[x][y]+=quantDL[x+1][y-1]+1;
                        if(detectaLimpia(quantDL,x,y)){
                            grupoDetectado++;
                        }
                    }
                }
                if(grupoDetectado>1){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectaLimpia(int[][] referenciaVerificar, int x, int y){
        if(cumple(referenciaVerificar[x][y])){
            referenciaVerificar[x][y]=0;
            return true;
        }
        return false;
    }

    private boolean cumple(int valor){
        return valor==3;
    }
}
