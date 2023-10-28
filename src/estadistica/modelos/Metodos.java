package estadistica.modelos;

import java.util.Arrays;

public class Metodos {
    
    public double promedio(double arr[]){
        double suma=0;
        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];           
        }
        return suma/arr.length;
    }
    
    public double mediana(double arr[]){
        Arrays.sort(arr);
        int n = arr.length;
        if (n%2 !=0) {
            return arr[n/2];
        } else {
            double medio1 = arr[(n-1)/2];
            double medio2 = arr[n/2];
            return (medio1+medio2)/2;     
        }        
    }
    
    public double moda(double arr[]){
        double moDa=-1;
        double maxCount=0;
        for (int i = 0; i < arr.length; i++) {
            int count =0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count>maxCount && count>1) {
                maxCount = count;
                 moDa = arr[i];
            }           
        }
        return  moDa;        
    }
    
    public double cuartil1(double arr[]){
        Arrays.sort(arr);
         double  cuartil1;
        if (arr.length%2==0) {
            cuartil1 = (1*arr.length)/4;
        } else {
            cuartil1 = (1*(arr.length + 1))/4;
        }
        return cuartil1;        
    }
    
    public double cuartil3(double arr[]){
         Arrays.sort(arr);
         double  cuartil3;
        if (arr.length%2==0) {
            cuartil3 = (3*arr.length)/4;
        } else {
            cuartil3 = (3*(arr.length + 1))/4;
        }
        return cuartil3;        
    }
    
    public double rango(double arr[]){
        Arrays.sort(arr);
        double rang = arr[arr.length-1] - arr[0];
        return rang;        
    }
    
    public double rangoCuartil(double arr[]){
        int posi1 = (int) cuartil1(arr);
        int posi3 = (int) cuartil3(arr);
        double cua1 = arr[posi1];
        double cua3 = arr[posi3];
        double res = cua3 - cua1;
        return res;        
    }
    
    public double varianza(double arr[]){      
        double su =0;        
        double promed = promedio(arr);
        for (int i = 0; i < arr.length; i++) {
            double au = arr[i] - promed;
            su += Math.pow(au, 2);           
        } 
         double resu = su / (arr.length - 1) ;
         return resu;        
    }
    
    public double deviacion(double arr[]){
            Arrays.sort(arr); 
            double vari = varianza(arr);
            double res = Math.sqrt(vari);
            return res;       
    }
    
    public double coeficiente(double arr[]){
        double prome = promedio(arr);
        double des = deviacion(arr);
        double res = (des/prome)*100;       
        return res;        
    }
}


