
/* Nombre: Memoria.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.09.2021
 			  Modificado el xx.09.2021 */

//import
import java.io.File;  
import java.io.IOException;
import java.security.PublicKey;
import java.io.FileNotFoundException;  
import java.util.ArrayList;     
import java.io.FileWriter;   

public class Memoria 
{
    private File archivo = new File("Programas.txt");
    private ArrayList <Programa> programas = new ArrayList<Programa>();
    private ArrayList <Programa> ejecucion = new ArrayList<Programa>();
    private ArrayList <Programa> cola = new ArrayList<Programa>();
    private String[] datos;
    private String tipo;
    private int tamanio;
    private int bloques;

    public Memoria(String ti, int ta) //constructor memoria SDR
    {
        tipo = ti;
        tamanio = ta;
        bloques = (tamanio * 1024) / 64;
    }

    public Memoria(String ti) // constructor memoria DDR
    {
        tipo = ti;
        tamanio = 4;
        bloques = 64;
    }

    public void leerArchivo()
    {
         //validación
         try 
         {         
             Scanner lector = new Scanner(archivo); //leer archivo
             while (lector.hasNextLine()) //analizar archivo linea poe linea
             {
                 datos = lector.nextLine().split(",");
 
                 //convertir datos del archivo a objetos de clase Espacio y Vehículo
             }
             lector.close(); //cerrar archivo
 
         } 
         catch (FileNotFoundException e) 
         {
             System.out.println("Error");
             e.printStackTrace();
         }
    }



}
