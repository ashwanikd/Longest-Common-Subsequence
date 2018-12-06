package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        //m.generateRandomDNA();
        m.generateLCS();

    }
    void generateLCS(){
        File f = new File("SequenceA.txt");
        String a = "",b = "";
        int c;
        try {
            FileReader fr = new FileReader(f);
            while((c = fr.read())!=-1){
                a = a + Character.toString((char)c);
            }
            f = new File("SequenceB.txt");
            fr = new FileReader(f);
            while((c = fr.read())!=-1){
                b = b + Character.toString((char)c);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        LCS l = new LCS(a,b);
        String x = l.Sequence();
        System.out.println("Subsequence found of length : " + x.length());
        try {
            f = new File("LongestSubSequence.txt");
            FileWriter fw  = new FileWriter(f,false);
            fw.write(x);
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    void generateRandomDNA(){
        GenerateRandomDNASequencece g = new GenerateRandomDNASequencece();
        GenerateRandomDNASequencece g1 = new GenerateRandomDNASequencece();
        String a = g.getDNA(10000);
        String b = g1.getDNA(10000);
        try {
            File f = new File("SequenceA.txt");
            FileWriter fw  = new FileWriter(f,false);
            fw.write(a);
            fw.close();
            f = new File("SequenceB.txt");
            fw  = new FileWriter(f,false);
            fw.write(b);
            fw.close();
            System.out.println("DNA generated successfully.....");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
