import java.util.HashMap;
import java.util.LinkedList;
public class EjemploHasmap {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>(); // llama al tipo de dato(clave) y luego
                                                                               // al dato (valor)
        capitalCities.put("England", "London");
        capitalCities.put("one", "uno");

        HashMap<Integer, String> ubicaciones = new HashMap<Integer, String>();

        
        ubicaciones.put(1, "Andrea");
        ubicaciones.put(2, "Camila");
        ubicaciones.put(5, "Jorge");
        ubicaciones.put(5, "Jorge");

        for(int j=0; j<10;j++){
            System.out.println("Iteración: "+j);
            for (int i: ubicaciones.keySet()) { //keySet (clave)
                System.out.println(ubicaciones.get(i));
            }
        }

        HashMap<String, LinkedList<String>> hobbies = new HashMap<>();
        LinkedList<String> p1=new LinkedList<>();
        LinkedList<String> p2=new LinkedList<>();
        p1.add("Dormir");
        p1.add("Cantar");
        p2.add("Correr");
        p2.add("Futbol");
        p2.add("Nadar");
        hobbies.put("Juan", p1);
        hobbies.put("Luis", p2);

    }
} 

