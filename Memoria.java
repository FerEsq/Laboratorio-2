
/* Nombre: Memoria.java
 * Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Java
 * Recursos: Visual Studio Code
 * Historial: Finalizado el xx.09.2021
 			  Modificado el xx.09.2021 */

//import
import java.util.Scanner;
import java.io.File;  
import java.io.IOException;
import java.security.PublicKey;
import java.io.FileNotFoundException;  
import java.util.ArrayList;     
import java.io.FileWriter;
import java.lang.IndexOutOfBoundsException;

public class Memoria 
{
    private File archivo = new File("Programas.txt");
    private ArrayList <Programa> programas = new ArrayList<Programa>();
    private ArrayList <Programa> ejecucion = new ArrayList<Programa>();
    private ArrayList <Programa> cola = new ArrayList<Programa>();
    private ArrayList <Programa> select = new ArrayList<Programa>();
    private String[] datos;
    private String tipo;
    private int tamanio;
    private int bloques;
    private int contador;

    public Memoria(String ti, int ta) //constructor memoria SDR
    {
        tipo = ti;
        tamanio = ta;
        bloques = (tamanio * 1024) / 64;
        contador = bloques;
    }

    public Memoria(String ti) // constructor memoria DDR
    {
        tipo = ti;
        tamanio = 4;
        bloques = 64;
        contador = bloques;
    }

    private void leerArchivo()
    {
        //validación
        try 
        {    
            programas.clear(); //limpiar arraylist de seleccionados (los programas se reemplazan) 
            Scanner lector = new Scanner(archivo); //leer archivo
            while (lector.hasNextLine()) //analizar archivo linea poe linea
            {
                datos = lector.nextLine().split(",");
                
                 //convertir datos del archivo a objetos de clase Programa
                Programa p = new Programa(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
                programas.add(p);
            }
            lector.close(); //cerrar archivo
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error de lectura del archivo");
        }
    }

    public ArrayList getProgramas() //obtener programas instalados
    {
        leerArchivo();
        return programas;
    }

    public void ingresarProgramas(String[] prg) //ingresar programas seleccionados por el usuario a la ram
    {
        //validación
        try
        {
            select.clear(); //limpiar arraylist de seleccionados (los programas se reemplazan)

            for(int i = 0; i < prg.length; i++) //ingresar programas seleccionadas al array select
            {
                select.add( programas.get(Integer.parseInt(prg[i])) );
            }

            for (int i = 0; i < select.size(); i++) //recorrer array select
            {
                if (contador > 0) //si aun hay bloques vacios
                {
                    if (contador >= select.get(i).getBloques()) //si el programa cabe en la memoria
                    {
                        ejecucion.add(select.get(i)); //ingresar programa a array de ejecutados
                        contador = contador - select.get(i).getBloques(); //restar los bloques que ocupa 
                    }
                    else //si el programa no cabe
                    {
                        cola.add(select.get(i)); //se ingresa a la cola
                    }
                }
                else //si ya no hay bloques vacios
                {
                    cola.add(select.get(i)); //se ingresa a la cola
                }
            }      
        }
        catch (IndexOutOfBoundsException e) //error
         {
            System.out.println("Alguno de los programas que ha ingresado no se encuentra instalado. Porfavor inténtelo de nuevo.");
         }
    }

    public int getTotal() //total de memoria en MB
    {
        return tamanio * 1024;
    }

    public int getDisponible() //memoria disponible en MB
    {
        int d = contador * 64;        
        return d;
    }

    public int getUso() //memoria en uso en MB
    {
        int u = (bloques - contador) * 64;
        return u;
    }

    public String[] getEjecucion()  //EVALUAR SI EL TAMAÑO ES 0 = NO HAY PROGRAMAS
    {
        String[] prgs = new String[ejecucion.size()]; //vector con los nombres de los programas
        for (int i = 0; i < ejecucion.size(); i++)
        {
            prgs[i] = ejecucion.get(i).getNombre(); //agregar nombres al vector
        }
        return prgs; //devolver
    }

    public String[] getCola() //EVALUAR SI EL TAMAÑO ES 0 = NO HAY PROGRAMAS
    {
        String[] prgs = new String[cola.size()]; //vector con los nombres de los programas
        for (int i = 0; i < cola.size(); i++)
        {
            prgs[i] = cola.get(i).getNombre(); //agregar nombres al vector
        }
        return prgs; //devolver
    }

    public int[] getPosicion(String name) //EVALUAR SI EL TAMAÑO ES 0 = NO EXISTE EL PROGRAMA
    {
        int p = -1; //posicion del programa
        int c = 0; //contador de bloques
        int[] posi = new int[2]; //array con bloque inicial y bloque final

        for (int i = 0; i < ejecucion.size(); i++) //Recorrer array ejecucion
        {
            if ((ejecucion.get(i).getNombre()).equals(name)) //buscar el programa
            {
                p = i; //guardar su posicion
            }
        }
        if (p == -1) //si no se encuentra el programa
        {
            return null; //vector vacio
        }
        else //sí si se encuentra el programa
        {
            for (int i = 0; i < p; i++)
            {
                c = c + ejecucion.get(i).getBloques(); //bloque inicial
            }
            posi[0] = c;
            posi[1] = c + ejecucion.get(p).getBloques(); //bloque final
            return posi; //devolver
        }
    }

    public int[] getEstado() //estado de la memoria
    {
        int[] espacios = new int[2]; 
        espacios[0] = bloques - contador; //en uso
        espacios[1] = contador; //vacios
        return espacios;
    }


}
