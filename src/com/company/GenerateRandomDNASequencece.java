package com.company;

public class GenerateRandomDNASequencece {
    String s;
    GenerateRandomDNASequencece(){
        s = "";
    }
    String getDNA(int x){
        for(int i=0;i<x;i++){
            s = s + Character.toString(getRandomBase());
        }
        return s;
    }
    char getRandomBase(){
        int x = (int)(Math.random()*5);
        if(x == 1)
            return 'A';
        else if(x == 2)
            return 'T';
        else if(x == 3)
            return 'G';
        else
            return 'C';
    }
}
