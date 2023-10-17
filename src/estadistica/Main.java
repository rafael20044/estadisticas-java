package estadistica;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int canNumeros,op2,op3,op;
    static double numeros[];
    public static void main(String[] args) {
        do {      
            comproba();
            System.out.println("-------------------------------------");
            meterNumeros();
            String opCo;
            do {        
                menu();
                System.out.println("Digite una opcion: ");
                opCo = sc.next();
                if (tieneLetras(opCo)) {
                    System.out.println("Solo numeros");
                    pausa(); 
                } else {
                    op = Integer.parseInt(opCo);
                 switch (op) {
                    case 1 -> {
                        System.out.println("El promedio es "+promedio(numeros));
                        pausa();
                    }
                    case 2 -> {
                        double me =mediana(numeros);
                        System.out.println("La mediana es: "+me);
                        pausa();
                    }
                    case 3 -> {
                        double mo = moda(numeros);
                        if (mo==-1) {
                            System.out.println("No hay moda");
                        } else {
                        System.out.println("La moda es "+mo);                       
                        }
                        pausa();
                    }
                    case 4 ->{
                        do {                            
                            menuCuartiles();
                            System.out.println("Digite una opcion");
                            op2 = sc.nextInt();
                            switch (op2) {
                                case 1 -> {
                                    int cu1 =(int) cuartile1(numeros);
                                    System.out.println("El 25% tiene menos o igual que "+numeros[cu1]);
                                    pausa();
                                }
                                case 2->{                                   
                                    System.out.println("El 50% tiene menos o igual que "+mediana(numeros));
                                    pausa();
                                } 
                                case 3->{
                                    int cu3 = (int) cuartil3(numeros);
                                    System.out.println("El 75% tiene menos o igual que "+numeros[cu3]);
                                    pausa();
                                }
                            }
                        } while (op2<4);
                    } 
                    case 5->{
                        System.out.println("El rango es "+rango(numeros));
                        pausa();
                    } 
                    case 6 ->{
                        System.out.println("El rango de los cuartiles es "+rangoCuartil(numeros));
                        pausa();
                    }
                    case 7->{
                        System.out.println("La varianza es "+varianza(numeros));
                        pausa();
                    }
                    case 8->{
                        System.out.println("La desviacion estandar es "+desviacion(numeros));
                        pausa();
                    }
                    case 9->{
                        System.out.println("El cofeficiente de variacion es "+coeficiente(numeros)+" %");
                        pausa();
                    }
                    
                }
                               
                }

           } while (op<10 || tieneLetras(opCo));          
            System.out.println("Quiere hacerlo otravez 1.si o 2.no");
                   op3 = sc.nextByte();
        } while (op3<2);


               
    }

    static void comproba(){
        String ca;
        do {            
             System.out.println("Digite la cantidad de números que va a digitar: ");
                ca = sc.next();
             if (tieneLetras(ca)) {
                 System.out.println("Solo numeros");
                 pausa();
            } else {
                 canNumeros = Integer.parseInt(ca);
                 if (canNumeros<0) {
                     System.out.println("DEBE DE SER UN NUMERO POSITIVO");
                 } else {
                    numeros = new double[canNumeros];                         
                 }         
             }

        } while (tieneLetras(ca)||canNumeros<0);
    }
    
    static boolean tieneLetras(String str){
        char caracter[] = str.toCharArray();
        int a =0;
        for (int i = 0; i < caracter.length; i++) {
            char c = caracter[i];
            if (!Character.isDigit(c) && c!='-') {
                a++;
            }           
        }
        return a>0;
    }
    
    static void meterNumeros(){
        double n;
        String a;
        for (int i = 0; i < numeros.length; i++) {
            do {                
             System.out.println("Digite un número: ");
            a = sc.next();
            if (tieneLetras(a)) {
                System.out.println("Solo numeros");
                pausa();
            }else{
              n = Double.parseDouble(a);
            numeros[i]=n;                    
            }               
            } while (tieneLetras(a));    
        }
    }
    
    static void pausa() {
        sc.nextLine();
        System.out.println("\t\nPresione enter para continuar...");
        sc.nextLine();
    }
    
    static void menu(){
        System.out.println("1.Promedio");
        System.out.println("2.Mediana");
        System.out.println("3.Moda");
        System.out.println("4.Cuartiles");
        System.out.println("5.Rango");
        System.out.println("6.Rango intercuartiles");
        System.out.println("7.Varianza");
        System.out.println("8.Desviación estandar");
        System.out.println("9.Coeficiente de variación");
        System.out.println("10.Salir");
         }
    
    static void menuCuartiles(){
        System.out.println("1.Cuartil 1");
        System.out.println("2.Cuartil 2");
        System.out.println("3.Cuartil 3");
        System.out.println("4.Salir");
        
    }
    
    static double promedio(double array[]){
        double res=0;
        for (int i = 0; i < numeros.length; i++) {
            res = numeros[i] + res;         
        }
        double prome = res / canNumeros;
        return prome;
    }
    
    static double mediana(double array[]){
        Arrays.sort(array);
        int n = numeros.length;
        if (n%2 !=0) {
            return array[n/2];
        } else {
            double medio1 = array[(n-1)/2];
            double medio2 = array[n/2];
            return (medio1+medio2)/2;     
        }
    }
    
    static double moda(double array[]){
        double moDa=-1;
        double maxCount=0;
        for (int i = 0; i < array.length; i++) {
            int count =0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count>maxCount && count>1) {
                maxCount = count;
                 moDa = array[i];
            }
            
        }
        return  moDa;
    }
    
    static double cuartile1(double array[]){
        Arrays.sort(array);
         double  cuartil1;
        if (array.length%2==0) {
            cuartil1 = (1*array.length)/4;
        } else {
            cuartil1 = (1*(array.length + 1))/4;
        }
        return cuartil1;
    }
    
    static double cuartil3(double array[]){
         Arrays.sort(array);
         double  cuartil3;
        if (array.length%2==0) {
            cuartil3 = (3*array.length)/4;
        } else {
            cuartil3 = (3*(array.length + 1))/4;
        }
        return cuartil3;
    }
    
    static double rango(double array[]){  
        Arrays.sort(array);
        double rang = array[array.length-1] - array[0];
        return rang;
    }
    
    static double rangoCuartil(double array[]){
        double cua1 = cuartile1(array);
        double cua3 = cuartil3(array);
        double res = cua3 - cua1;
        return res;
    }
    
    static double varianza(double array[]){
        double array2[] = new double[array.length];

        double promed = promedio(array);
        for (int i = 0; i < array.length; i++) {
            double au = array[i] - promed;
            array2[i]=Math.pow(au, 2);
        } 
          Arrays.sort(array2);        
        double su =0;
        for (int i = 0; i < array2.length; i++) {
            su += array2[i]; 
        }
         double resu = su / (array2.length - 1) ;
         return resu;
    }
    
    static double desviacion(double array[]){
            Arrays.sort(array); 
            double vari = varianza(array);
            double res = Math.sqrt(vari);
            return res;
    }
    
    static double coeficiente(double array[]){
        double prome = promedio(array);
        double des = desviacion(array);
        double res = (des/prome)*100;
        
        return res;
    }  
}
