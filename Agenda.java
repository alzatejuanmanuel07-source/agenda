package Funciones;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
public class Agenda {
    //Variables globales
    static int op=0;
    static Scanner sc= new Scanner(System.in);
     static LinkedList<String> documentos= new LinkedList<>();
     static LinkedList<String> nombres= new LinkedList<>();
      static  LinkedList<String> apellidos= new LinkedList<>();
         static LinkedList<String> correos= new LinkedList<>();
         static  LinkedList<String> celulares= new LinkedList<>();
         static Map<String,LinkedList<String>> estudiantes=new HashMap<>();
         static LinkedList<String> notas = new LinkedList<>();
         // nota 1 hasta el 3 algoritmos
         static LinkedList<Double> alg1 = new LinkedList<>();
         static LinkedList<Double> alg2 = new LinkedList<>();
         static LinkedList<Double> alg3 = new LinkedList<>();
         //notas 1 hasta el 3 de ingles
         static LinkedList<Double> In1 = new LinkedList<>();
         static LinkedList<Double> In2 = new LinkedList<>();
         static LinkedList<Double> In3 = new LinkedList<>();
         //notas 1 hasta el 3 de fisica
         static LinkedList<Double> Fi1 = new LinkedList<>();
         static LinkedList<Double> Fi2 = new LinkedList<>();
         static LinkedList<Double> Fi3 = new LinkedList<>();



          
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        System.out.println("## Menu de opciones ##");
        System.out.println("1. Crear contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Modificar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Lista de contactos");
        System.out.println("6. Generar tabla");
        System.out.println("7.guardarContactos");
        System.out.println("8.cargarContactos");
        System.out.println("9.fecha_nacimiento");
        System.out.println("10.generarnotas");
        System.out.println("10. salir");
        System.out.println("Seleccione una opcion del (1..9)");
        op=sc.nextInt();

        switch (op) {
            case 1:
                Crearcontacto();
                
                break;
                 case  2:
                 Buscarcontacto();
                
                break;
                 case  3:
                 Modificarcontacto();
                
                break;
                 case 4:
                 Eliminarcontacto();
                
                break;
                 case  5:
                 Listarcontactos();
                
                break;
                 case  6:
                 GenerarTabla();
                
                break;
                case  7:
                 guardarContactos();
                
                break;
                case  8:
                 cargarContactos();
                
                break;
                case  9:
                 fecha_nacimiento();

                 case  10:
                 generarnotas();
            
                break;
                 case  11:
                 Salir();
                
                break;
         
            default:
            System.out.println("Error ingrese una opción valida");
            volverMenu();
                break;
        }
    }
    private static void generarnotas() {
        System.out.println("Ingrese nota 1 de Algoritmos:");
        double a1 = sc.nextDouble();
        System.out.println("Ingrese nota 2 de Algoritmos:");
        double a2 = sc.nextDouble();
        System.out.println("Ingrese nota 3 de Algoritmos:");
        double a3 = sc.nextDouble();

        System.out.println("Ingrese nota 1 de Inglés:");
        double i1 = sc.nextDouble();
        System.out.println("Ingrese nota 2 de Inglés:");
        double i2 = sc.nextDouble();
        System.out.println("Ingrese nota 3 de Inglés:");
        double i3 = sc.nextDouble();

        System.out.println("Ingrese nota 1 de Física:");
        double f1 = sc.nextDouble();
        System.out.println("Ingrese nota 2 de Física:");
        double f2 = sc.nextDouble();
        System.out.println("Ingrese nota 3 de Física:");
        double f3 = sc.nextDouble();
       
    }
    private static void fecha_nacimiento() {
       Scanner sc = new Scanner (System.in);
       LocalDate hoy = LocalDate.now();

       int añoN, mesN, diaN, año, mes, dia =0;

       //Fecha actual
       int añoA = hoy.getYear();
       int mesA = hoy.getMonthValue();
       int diaA = hoy.getDayOfMonth();

       //Datos del usuario

       System.out.println("Ingrese su año de nacimiento");
        añoN = sc.nextInt();
       System.out.println("Ingrese su mes de nacimiento");
        mesN = sc.nextInt();
       System.out.println("Ingrese su día de nacimiento");
        diaN = sc.nextInt();

        //Calculo de la edad

        //DIAS
        if(diaA >= diaN){
            dia = diaA - diaN;
        }else{ //se pide prestado 1 mes sumando 30 dias a diaA y restando 1 mes a mesA
            diaA += 30;
            mesA --;
            dia = diaA - diaN;
        }

        //MESES
        if (mesA >= mesN){
            mes = mesA - mesN;
        }else{ //se pide prestado 1 año sumando 12 meses a añoA y restando 1 año a añoA
            mesA += 12;
            añoA --;
            mes = mesA - mesN;
        }

        //AÑOS
        año = añoA - añoN;

        System.out.println("Su edad es: " + año + " años, " + mes + " meses y " + dia + "dias"); 

    }
    private static void guardarContactos() {
        //Definir el nombre del archivo
        String nombreArchivo="Agenda_contactos.txt";
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (int i=0; i<documentos.size();i++) {
                String contacto= documentos.get(i) +","+
                nombres.get(i)+","+
                apellidos.get(i)+","+
                celulares.get(i)+","+
                correos.get(i);
                escritor.println(contacto);
            }
            System.out.println("Los contactos han sido guardados...");
            
        } catch (IOException e ) {
            System.out.println("Error al escribir en el archivo;" +e.getMessage() );
        }
        volverMenu();
    }
    private static void cargarContactos() {
        String nombreArchivo="Agenda_contactos.txt";
        File archivo = new File(nombreArchivo);

        //Limpiar las listas
        documentos.clear();
        nombres.clear();
        apellidos.clear();
        correos.clear();
        celulares.clear();

        try(Scanner lectorArchivo= new Scanner(archivo)){
            int contador=0;
            while (lectorArchivo.hasNextLine()) {
                String linea=lectorArchivo.nextLine();
                String[] datos=linea.split(",");

                if (datos.length==5) {
                    documentos.add(datos[0].trim());
                    nombres.add(datos[1].trim());
                    apellidos.add(datos[2].trim());
                    celulares.add(datos[3].trim());
                    correos.add(datos[4].trim());
                    contador++;
                    
                }   
            }
            System.out.println("se cargaron: "+contador+"registros...");
        } catch (FileNotFoundException e){
            System.out.println("Error archivo no encontrado...");
        } catch (Exception e){
            System.out.println("Error al leer el archivo: "+e.getMessage());
        }
        volverMenu();
            
    }
    private static void Salir() {
       System.out.println("SALIENDO!!");
       sc.close();
       System.exit(0);
    }
    private static void Listarcontactos() {
        System.out.println("Contactos desde las listas");
        for(int i=0; i< correos.size();i++){
            System.out.println(nombres.get(i) + " " + apellidos.get(i)+ " " + correos.get(i)+ " "+ celulares.get(i));
            
        }
        System.out.println("\n Contactos desde el HashMap directo");
        System.out.println(estudiantes);
        System.out.println("\n Contactos desde HashMap con un formato");
        for (Map.Entry<String,LinkedList<String>>entry : estudiantes.entrySet()) {
            String doc=entry.getKey();
            LinkedList<String> est=entry.getValue();
            System.out.print("Documento: "+doc + " ");
            System.out.print("Nombres: "+est.get(0) + " ");
            System.out.print("Apellidos: "+est.get(1) + " ");
            System.out.print("Celulares: "+est.get(2) + " ");
            System.out.print("Correo: "+est.get(3) + " ");
            
        }
        volverMenu();
    }
        private static void GenerarTabla(){
            for (int index = 0; index<documentos.size();index++) {
                String clave= documentos.get(index);
                LinkedList<String> valor= new LinkedList<>();
                valor.add(nombres.get(index));
                valor.add(apellidos.get(index));
                valor.add(celulares.get(index));
                valor.add(correos.get(index));
                estudiantes.put(clave, valor);
                
            }
            volverMenu();
        } 
    private static void Eliminarcontacto() {
        String ced="";
        String rta="";
        System.out.println("Ingrese el documento que desea eliminar");
        ced=sc.next();
        int pos=documentos.indexOf(ced);
        //pos
        if (pos==-1) {
            System.out.println("Registro no encontrado!!!");
            volverMenu();
            
        }else{
            System.out.println("Estas seguro de eliminar el registro (s/n)");
            rta=rta.toLowerCase();
            rta=sc.next();
            if (rta.equals("s")){
            documentos.remove(pos);
            nombres.remove(pos);
            apellidos.remove(pos);
            correos.remove(pos);
            celulares.remove(pos);
            volverMenu();
                
            }else{
                volverMenu();
            }
                
            }
     }   
        
    
    private static void Modificarcontacto(){
         String ced="";
         System.out.println("Ingrese el documento del contacto que desea modificar: ");
         ced=sc.next();
         int pos=-1;
         pos=documentos.indexOf(ced);
         if (pos== -1){
            System.out.println("Registro no encontrado");
            volverMenu();
         }else{
         String documento="", nombre="", apellido="",correo="",celular="";
        System.out.println("Ingrese documento: ");
        documento= sc.next();
        System.out.println("Ingrese nombre: ");
        nombre= sc.next();
        System.out.println("Ingrese apellidos: ");
        apellido= sc.next();
        System.out.println("Ingrese correo: ");
        correo= sc.next();
        System.out.println("Ingrese celular: ");
        celular= sc.next();
        if (validar(documento, correo, celular)) {
        documentos.set(pos,documento);
        nombres.set(pos,nombre);
        celulares.set(pos,celular);
        correos.set(pos, celular);
        volverMenu();    
        }
     }
    }
        
    
    private static void Buscarcontacto() {
        String ced="";
        System.out.println("Ingrese el documento que desea buscar");
        ced=sc.next();
        int pos=-1;
        for(int i=0;i<documentos.size();i++){
            if (documentos.get(i).equals(ced)){
                pos=i;
                break;
            }
        }
        if (pos== -1){
            System.out.println("Registro no encontrado!!!");
            volverMenu();
        }else{
            System.out.println(nombres.get(pos)+" "+apellidos.get(pos)+" "+ correos.get(pos)+" "+celulares.get(pos));
            volverMenu();
        }
    
    }
    private static void Crearcontacto() { 
        String documento="", nombre="", apellido="",correo="",celular="";
        System.out.println("Ingrese documento: ");
        documento= sc.next();
        System.out.println("Ingrese nombre: ");
        nombre= sc.next();
        System.out.println("Ingrese apellidos: ");
        apellido= sc.next();
        System.out.println("Ingrese correo: ");
        correo= sc.next();
        System.out.println("Ingrese celular: ");
        celular= sc.next();
        if (validar(documento, correo, celular)){
        documentos.add(documento);
        nombres.add(nombre);
        celulares.add(celular);
        correos.add(correo);
        volverMenu();
            
        }else{
            volverMenu();
        }
    }
    private static void volverMenu(){
        Scanner sc1= new Scanner(System.in);
    System.out.println("\n presione una tecla para volver al menu...");
    sc1.nextLine();
    sc1.nextLine();
    menu();
    }
    public static boolean validar(String doc, String cor, String cel){
        if(documentos.contains(doc)){
            System.out.println("El documento: "+ doc +"ya esta registrado");
            return false;
        
     }else if (correos.contains(cor)) {
        System.out.println("El correo:"+ cor+"ya esta registrado");
        return false;
     }else if (celulares.contains(cel)) {
        System.out.println("El celular: "+cel+"ya esta registrado");
        return false;
     }
     return true;
     }
 }  

 


    

