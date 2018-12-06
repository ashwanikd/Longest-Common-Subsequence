package com.company;

public class LCS {
    String a;
    String b;
    char[][] direction;
    int[][] matrix;
    String result;
    LCS(String x,String y){
        a = x;
        b = y;
        result = "";
        direction = new char[a.length()+1][b.length()+1];
        matrix = new int[a.length()+1][b.length()+1];
        algorithm();
    }
    String Sequence(){
        return result;
    }
    void algorithm(){
        for(int i=0;i<b.length()+1;i++){
            matrix[0][i] = 0;
        }
        for(int i=0;i<a.length()+1;i++){
            matrix[i][0] = 0;
        }
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                if(a.charAt(i) == b.charAt(j)){
                    matrix[i+1][j+1] = matrix[i][j]+1;
                    direction[i+1][j+1] = 'd';
                }else {
                    if(matrix[i][j+1] > matrix[i+1][j]){
                        matrix[i+1][j+1] = matrix[i][j+1];
                        direction[i+1][j+1] = 'u';
                    }else {
                        matrix[i+1][j+1] = matrix[i+1][j];
                        direction[i+1][j+1] = 'l';
                    }
                }
            }
        }
        //printMatrix();
        int i = a.length();
        int j = b.length();
        while (matrix[i][j] != 0){
            if(direction[i][j] == 'd'){
                result = result + a.charAt(i-1);
                i--;
                j--;
            }else if(direction[i][j] == 'l'){
                j--;
            }else if(direction[i][j] == 'u'){
                i--;
            }
        }
        String t = "";
        for(i=result.length()-1;i>=0;i--){
            t = t + Character.toString(result.charAt(i));
        }
        result = t;
    }
    void printMatrix(){
        for(int i=0;i<a.length()+1;i++){
            for(int j=0;j<b.length()+1;j++){
                System.out.print(direction[i][j]+" ");
            }
            System.out.println();
        }
    }
}
