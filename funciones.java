package Funciones;

import java.util.Scanner;

public class funciones {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num1=0, num2=0, num3=0, res=0;
        System.out.println("Ingrese el primer numero: ");
        num1= sc.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        num2= sc.nextInt();
        System.out.println("Ingrese el tercer numero: ");
        num3= sc.nextInt();
        ordenarV2(num1, num2, num3);
    }
    public static int sumar(int n1, int n2, int n3){
        int res= n1+n2+n3;
        return res;
    }
    public static int[] ordenar(int n1, int n2, int n3){
        int[] numeros= new int[3];
        if (n1!=n2 && n2!=n3 && n1!=n3) {
            //Buscar el menor
            if (n1<n2 && n1<n3) {
                numeros[0]=n1;
            }else if (n2<n1 && n2<n3) {
                numeros[0]=n2;
            }else{
                numeros[0]=n3;
            }
            //Buscar el mayor
            if (n1>n2 && n1>n3) {
                numeros[2]=n1;
            }else if (n2>n1 && n2>n3) {
                numeros[2]=n2;
            }else if(n3>n1 && n3>n2){
                numeros[2]=n3;
            }
            //Buscar el del medio
             if (n1<n2 && n1>n3) {
                numeros[1]=n1;
            }else if (n2<n1 && n2>n3) {
                    numeros[1]=n2;
            }else if (n3<n1 && n3>n2) {
                numeros[1]=n3;
            }
         }
         System.out.println("Numeros ordenados:");
          return numeros;
        }
        public static int menor(int n1, int n2, int n3){
            int menor=0;
            if (n1 < n2 && n1<n3) {
                menor=n1;
            }else if (n2<n1 && n2<n3) {
                menor=n2;
            }else if (n3<n1 && n3<n2) {
                menor=n3;
            }
            return menor;
        }
        public static int mayor(int n1, int n2, int n3){
            int mayor=0;
            if (n1 > n2 && n1>n3) {
                mayor=n1;
            }else if (n2>n1 && n2>n3) {
                mayor=n2;
            }else if (n3>n1 && n3>n2) {
                mayor=n3;
            }
            return mayor;
        }

        public static int medio(int n1, int n2, int n3){
            int medio=0;
            if (n1>n2 && n1<n3) {
                medio=n1;
            }else if (n2>n1 && n2<n3) {
                medio=n2;
            }else if (n3>n1 && n3<n2) {
                medio=n3;
            } else if (n1<n2 && n1>n3) {
                medio=n1;
            }else if (n2<n1 && n2>n3) {
                medio=n2;
            }else if (n3<n1 && n3>n2) {
                medio=n3;
            } 
            return medio;
        }
        public static void ordenarV2(int n1,int n2, int n3){
            if (n1!=n2 && n1!=n3 && n2!=n3) {
                System.out.println("el menor es: "+menor(n1, n2, n3));
                System.out.println("el medio es: "+medio(n1, n2, n3));
                System.out.println("el mayor es: "+mayor(n1, n2, n3));
            }else{
                System.out.println(" Solo se ordenan numeros diferentes... ");
            }
        }
    }
    

