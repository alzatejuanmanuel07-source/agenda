package Funciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class listas1 {
    public static void main(String[] args) {
        List<String> nombres = new LinkedList<>();
        System.out.println(nombres.size());
        nombres.add("Jorge ");
        nombres.add("Curioso");
        System.out.println(nombres.size());

        //Quitar una posicion
        //nombres.remove(1);
        //System.out.println("despues de eliminar: "+ nombres.size());
        


        LinkedList<Integer> numeros = new LinkedList<>();
        numeros.add(5);
        numeros.add(88);
        numeros.add(5);
        numeros.add(9);
        numeros.add(18);
        for (Integer x: numeros){
            System.out.println(x);
        }
        Collections.sort(numeros);
        System.out.println("Ordenados");
        for (Integer y : numeros) {
            System.out.println(y);
        }
         numeros = numeros.reversed();
         System.out.println("descendente");
         for (Integer y : numeros) {
            System.out.println(y);
            
         }

        ArrayList<Double> notas= new ArrayList<>();
        notas.add(5.88);
        notas.add(6.05);
        notas.add(7.2);
        System.out.println("notas: "+notas.size());

        LinkedList<Boolean> aciertos= new LinkedList<>();
        aciertos.add(true);
        aciertos.add(false);

        for(int i=0; i<nombres.size();i++){
            System.out.println(nombres.get(i));
        } 
        for (Boolean x: aciertos){
            System.out.println(x);
        }
        int cont=0;
        while (cont < numeros.size()) {
            System.out.println(numeros.get(cont));
            cont++;
            
        }
        System.out.println("con do while");
        int cont1=0;
        do{
            System.out.println(numeros.get(cont));
        
        }while(cont< numeros.size());

        int definitiva=5;
        /*while (definitiva > 5) {
            System.out.println("Ingrese un valor");
            
        }*/
     }
    }

