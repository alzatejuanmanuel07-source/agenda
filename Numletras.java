package Funciones;

import java.util.Scanner;

public class Numletras {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num=0;
        System.out.println("Ingrese valor numerico");
        num=sc.nextInt();
        convertir(num);
    }
    public static String unidades (int uni){
        String let="";
        switch (uni){
            case 1:
                let="uno";
                break;
            case 2:
                let="dos";
                break;
            case 3:
                let="tres";
                break;
            case 4:
                let="cuatro";
                break;
            case 5:
                let="cinco";
                break;
            case 6:
                let="seis";
                break;
            case 7:
                let="siete";
                break;
            case 8:
                let="ocho";
                break;
            case 9:
                let="nueve";
                break;
            case 10:
                let="diez";
                break;
            case 11:
                let="once";
                break;
            case 12:
                let="doce";
                break;
            case 13:
                let="trece";
                break;
            case 14:
                let="catorce";
                break;
            case 15:
                let="quince";
                break;
        }

        return let;
    }
    public static String decenas(int dec, int uni){
        String let="";
        switch (dec) {
            case 1:let=(uni>0)?"dieci":"diez";break;
            case 2:let=(uni>0)?"veinti":"veinte";break;
            case 3:let=(uni>0)?"treinta y":"treint";break;
            case 4:let=(uni>0)?"cuarenta y ":"cuarenta";break;
            case 5:let=(uni>0)?"cincuenta y ":"cincuenta";break;
            case 6:let=(uni>0)?"sesenta y ":"sesenta";break;
            case 7:let=(uni>0)?"setenta y ":"setenta";break;
            case 8:let=(uni>0)?"ochenta y ":"ochenta";break;
            case 9:let=(uni>0)?"noventa y ":"noventa";break;
        }
        return let;
    }
    public static String centenas(int cen){
        String let="";
        switch (cen) {
            case 1: let="ciento "; break;
            case 2: let="doscientos "; break;
            case 3: let="trecientos "; break;
            case 4: let="cuatrocientos "; break;
            case 5: let="quinientos "; break;
            case 6: let="seiscientos  "; break;
            case 7: let="setesientos  "; break;
            case 8: let="ochocientos  "; break;
            case 9: let="novecientos "; break;
        }
        return let;
    }
    public static String milesimas(int mil){
        String let="";
        switch (mil) {
            case 1: let="mil "; break;
            case 2: let="dos mil "; break;
            case 3: let="tres mil "; break;
            case 4: let="cuatro mil "; break;
            case 5: let="cinco mil "; break;
            case 6: let="seis mil "; break;
            case 7: let="siete mil "; break;
            case 8: let="ocho mil "; break;
            case 9: let="nueve mil "; break;
        }
        return let;
    }


    public static void convertir(int num){
        int uni=0, dec=0, centenas=0, temp=0, mil=0;
        if (num<16) {
            System.out.println(unidades(num));
        }else if(num>15 && num<100){
            dec=num/10;
            uni= num%10;
            System.out.println(decenas(dec,uni) + unidades(uni));
        }else if(num==100){
            System.out.println("cien");
        }else if(num>100 && num<1000){
            centenas=num/100;
            temp= num%100;
            if(temp>15){
                dec= (num%100)/10;
                uni=num%10;
                System.out.println(centenas(centenas) + decenas(dec, uni)+unidades(uni));

            }else{
                System.out.println(centenas(centenas) + unidades(temp));
            }
        }else if(num>1000 && num<10000){
            mil=num /1000;
            temp=num%1000;
            centenas=temp/100;
            temp=temp%100;
            if (temp>15){
                dec=(temp%100)/10;
                uni=temp%10;
                System.out.println(milesimas(mil)+centenas(centenas)+decenas(dec, uni)+unidades(uni));
                
            }else if(temp>0){
                System.out.println(milesimas(mil)+centenas(centenas)+unidades(temp));
            }else{
                System.out.println(milesimas(mil));
            }

        }
    }
}
